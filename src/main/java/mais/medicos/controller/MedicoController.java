/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mais.medicos.controller;

import mais.medicos.domain.Medico;
import mais.medicos.domain.Usuario;
import mais.medicos.facade.MedicoFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;


@Controller
@Secured({"ADMIN", "PACIENTE"})
public class MedicoController implements Serializable {

    private static Logger log = LoggerFactory.getLogger(MedicoController.class.getName());

    @Autowired
    private MedicoFacade medicoFacade;

    /**
     *
     * @return
     */
    @ModelAttribute("allMedicos")
    public List<Medico> populateVisualizarMedico() {
        return this.medicoFacade.listarMedicos();

    }


    @RequestMapping(value = "/app/medico")
    public String medicoHome(final Medico medico) {
        return "app/medico/home";
    }


    @PostMapping(value = "/app/medico", params = {"save"})
    public String saveMedico(@Valid final Medico medico, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("medico", medico);
            return "app/medico/home";
        }       
        medico.getUsuario().setTipoUsuario(Usuario.TipoUsuario.MEDICO);

        this.medicoFacade.inserirMedico(medico);
        model.clear();
        return "redirect:/app/medico";

    }

}
