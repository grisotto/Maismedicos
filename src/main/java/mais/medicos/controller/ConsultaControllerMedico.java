/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mais.medicos.controller;

import mais.medicos.domain.Consulta;
import mais.medicos.facade.ConsultaFacade;
import mais.medicos.service.MedicoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@Controller
@Secured({"MEDICO", "PACIENTE"})
public class ConsultaControllerMedico implements Serializable {

    private static Logger log = LoggerFactory.getLogger(ConsultaControllerMedico.class.getName());
//    private static final long serialVersionUID = -2178567204438375167L;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private ConsultaFacade facade;

    /**
     *
     * @return
     */
    @RequestMapping(value = "/app/consultamedico")
    public String consultaHome(final Consulta consulta, ModelMap map) {

        map.addAttribute("todosMedicos", medicoService.findAll());
        return "app/consultamedico/home";
    }


    @PostMapping(value = "/app/consultamedico", params = {"save"})
    public String saveConsulta(@Valid final Consulta consulta, @Valid Integer idMedico, final BindingResult bindingResult, final ModelMap model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("consulta", consulta);
            return "app/consultamedico/home";
        }
        facade.createConsulta(consulta, idMedico);
        model.clear();
        return "redirect:/app/consultamedico";
    }


    @ModelAttribute("allConsultasMedico")
    public List<Consulta> populateVisualizarConsultaMedico() {
        return facade.consultasOfMedico();

    }

    @GetMapping(value = "/app/consultamedico/{id}")
    public String showTurma(@PathVariable Integer id, ModelMap map) {

//        map.addAttribute("consulta", facade.findTurma(id));
//
//        map.addAttribute("tarefas", facade.findTurma(id).getTarefas());

        map.addAttribute("todosMedicos", medicoService.findAll());

        return "app/consultamedico/show";
    }



//    @PostMapping(value = "/app/consulta/add/aluno", params = {"save"})
//    public String adicionarAuluno(@Valid Integer turmaID, @Valid Integer alunoID, ModelMap map) {
//
//        Turma insertAluno = facade.insertAluno(turmaID, alunoID);
//
//        map.addAttribute("turma", insertAluno);
//
//        return "redirect:/app/consulta/" + turmaID;
//
//    }


}
