/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.controller;

import java.util.List;

import br.ufg.jatai.fsw.sisquest.model.Professor;
import br.ufg.jatai.fsw.sisquest.model.Usuario;
import br.ufg.jatai.fsw.sisquest.service.ProfessorService;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import br.ufg.jatai.fsw.sisquest.service.ProfessorServiceImpl;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author rafael
 */
@Controller
public class ProfessorController implements Serializable {
    
    private static Logger log = LoggerFactory.getLogger(ProfessorController.class.getName());
    
    @Autowired
    private ProfessorService service;
    
    @ModelAttribute("allProfessores")
    public List<Professor> populateVisualizarProfessor() {
        return this.service.findAll();
        
    }
    
    @RequestMapping(value = "/app/professor")
    public String professorHome(final Professor professor) {
        return "/app/professor/home";
    }
    
    @PostMapping(value = "/app/professor", params = {"save"})
    public String saveProfessor(@Valid final Professor professor, final BindingResult bindingResult, final ModelMap model) {
//        bindingResult.addError(new FieldError("Professor", "professor.usuario.senha", "Deu merda"));
        if (bindingResult.hasErrors()) {
            model.addAttribute("professor", professor);            
            return "/app/professor/home";
        }
        professor.getUsuario().setTipoUsuario(Usuario.TipoUsuario.PROFESSOR);
        professor.getUsuario().setSenha("123");
        log.error(professor.toString());

        this.service.inserir(professor);
//        model.clear();
        return "redirect:/app/professor";
        
    }
    
}
