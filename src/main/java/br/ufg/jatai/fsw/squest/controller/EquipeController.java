/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.controller;

import java.io.Serializable;

import br.ufg.jatai.fsw.squest.domain.Aluno;
import br.ufg.jatai.fsw.squest.domain.Equipe;
import br.ufg.jatai.fsw.squest.facade.EquipeFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author dfranco
 */
@Controller
@RequestMapping("/app/equipe")
public class EquipeController implements Serializable {

    private static Logger log = LoggerFactory.getLogger(EquipeController.class.getName());

    private EquipeFacade equipeFacade;


    /**
     * @return
     */
    @GetMapping(value = "/")
    public String turmaHome() {
        return "/app/equipe/home";
    }

    @PostMapping(value = "/")
    public String createEquipe(@Valid final Equipe equipe, final BindingResult bindingResult, final ModelMap model) {
    	 System.out.println("ENTROU AQUI nas equipes");
        if (bindingResult.hasErrors()) {
            model.addAttribute("equipe", equipe);
        }
        equipeFacade.adicionaEquipe(equipe);
        //deve retornar para a mesma pagina, /app/tarefa/{equipe.tarefa.id}
        return "redirect:/app/tarefa";

    }

    @PostMapping(value = "/{idEquipe}/addAluno")
    public void addAluno(@Valid final Aluno aluno, @Valid final Integer idEquipe, final BindingResult bindingResult, final ModelMap model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("idEquipe", idEquipe);
            model.addAttribute("aluno", aluno);
        }

        equipeFacade.addAluno(aluno,idEquipe);
    }


}
