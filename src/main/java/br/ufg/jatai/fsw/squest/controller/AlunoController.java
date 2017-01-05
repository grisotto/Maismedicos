/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.controller;

import java.util.List;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import br.ufg.jatai.fsw.squest.domain.Aluno;
import br.ufg.jatai.fsw.squest.service.AlunoServiceImpl;
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
public class AlunoController implements Serializable {

    private static Logger log = LoggerFactory.getLogger(TeamController.class.getName());

    @Autowired
    private AlunoServiceImpl AlunoService;

    /**
     * Cria um attributo AllAlunos que busca todos os alunos cadastrados
     *
     * @return
     */
    @ModelAttribute("allAlunos")
    public List<Aluno> populateVisualizarAlunos() {
        return this.AlunoService.findAll();

    }

    @RequestMapping(value = "/app/aluno")
    public String alunoHome(final Aluno aluno) {
        return "/app/aluno/home";
    }

    /**
     * Nesta funcao eh adicionado o aluno pelo controller. Faz a validacao pelo
     * ModelAttribute e caso aconteca erro, o BindingResult retorna.
     *
     * @param aluno
     * @param bindingResult
     * @param model
     * @return
     */

    @PostMapping("/app/aluno")
    public String saveAluno(@ModelAttribute("aluno") @Valid final Aluno aluno, final BindingResult bindingResult, final ModelMap model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("aluno", aluno);
            return "/app/aluno/home";
        }
        this.AlunoService.inserir(aluno);
        model.clear();
        return "redirect:/app/aluno";

    }

}
