/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.controller;

import java.util.List;

import br.ufg.jatai.fsw.squest.domain.Professor;
import br.ufg.jatai.fsw.squest.domain.Usuario;
import br.ufg.jatai.fsw.squest.facade.ProfessorFacade;
import br.ufg.jatai.fsw.squest.service.ProfessorService;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author rafael
 */
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class ProfessorController implements Serializable {

    private static Logger log = LoggerFactory.getLogger(ProfessorController.class.getName());

    @Autowired
    private ProfessorFacade professorFacade;

    /**
     *
     * @return
     */
    @ModelAttribute("allProfessores")
    public List<Professor> populateVisualizarProfessor() {
        return this.professorFacade.listarProfessores();

    }

    /**
     *
     * @param professor
     * @return
     */
    @RequestMapping(value = "/app/professor")
    public String professorHome(final Professor professor) {
        return "app/professor/home";
    }

    /**
     *
     * @param professor
     * @param bindingResult
     * @param model
     * @return
     */
    @PostMapping(value = "/app/professor", params = {"save"})
    public String saveProfessor(@Valid final Professor professor, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("professor", professor);
            return "app/professor/home";
        }       
        professor.getUsuario().setTipoUsuario(Usuario.TipoUsuario.PROFESSOR);

        this.professorFacade.inserirProfessor(professor);
        model.clear();
        return "redirect:/app/professor";

    }

}
