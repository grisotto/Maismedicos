/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.controller;

import br.ufg.jatai.fsw.sisquest.annotations.Permissao;
import br.ufg.jatai.fsw.sisquest.model.Turma;
import br.ufg.jatai.fsw.sisquest.model.Usuario;
import br.ufg.jatai.fsw.sisquest.service.AlunoService;
import br.ufg.jatai.fsw.sisquest.service.TurmaService;
import java.io.Serializable;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dfranco
 */
@Controller
public class TurmaController implements Serializable {

    private static Logger log = LoggerFactory.getLogger(TurmaController.class.getName());
    private static final long serialVersionUID = -2178567604078375167L;

    @Autowired
    private TurmaService service;
    @Autowired
    private AlunoService aService;

    /**
     *
     * @return
     */
    @Permissao(Usuario.TipoUsuario.PROFESSOR)
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/app/turma")
    public String turmaHome() {
        return "/app/turma/home";
    }

    @RequestMapping(value = "/app/turma/home", params = {"save"})
    public String saveProfessor(@Valid final Turma turma, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("turma", turma);
            return "app/turma";
        }

        this.service.inserir(turma);
//        model.clear();
        return "redirect:/app/turma";
    }

    @ModelAttribute("allTurmas")
    public List<Turma> populateVisualizarTurma() {
        return this.service.findAll();

    }

    @GetMapping(value = "/app/turma/{id}")
    public String showTurma(@PathVariable Integer id, ModelMap map) {
        map.addAttribute("turma", service.find(id));
        map.addAttribute("alunos", service.find(id).getAlunos());

        //NUNCA MAIS FAZ ISSO DYEIMYS
        map.addAttribute("todosAlunos", aService.findAll());

        System.out.println(id);
        return "/app/turma/show";
    }
}
