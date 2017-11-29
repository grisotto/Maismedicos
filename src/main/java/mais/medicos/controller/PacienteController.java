/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mais.medicos.controller;

import mais.medicos.domain.Paciente;
import mais.medicos.domain.Usuario;
import mais.medicos.facade.PacienteFacade;
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
@Secured({"ADMIN", "MEDICO"})
public class PacienteController implements Serializable {

    private static Logger log = LoggerFactory.getLogger(PacienteController.class.getName());

    @Autowired
    private PacienteFacade pacienteFacade;

    /**
     *
     * @return
     */
    @ModelAttribute("allPacientes")
    public List<Paciente> populateVisualizarPaciente() {
        return this.pacienteFacade.listarPacientes();

    }


    @RequestMapping(value = "/app/paciente")
    public String pacienteHome(final Paciente paciente) {
        return "app/paciente/home";
    }


    @PostMapping(value = "/app/paciente", params = {"save"})
    public String savePaciente(@Valid final Paciente paciente, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("paciente", paciente);
            return "app/paciente/home";
        }
        paciente.getUsuario().setTipoUsuario(Usuario.TipoUsuario.PACIENTE);

        this.pacienteFacade.inserirPaciente(paciente);
        model.clear();
        return "redirect:/app/paciente";

    }

}
