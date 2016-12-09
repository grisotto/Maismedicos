/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.controller;

import br.ufg.jatai.fsw.sisquest.model.Tarefa;
import br.ufg.jatai.fsw.sisquest.service.TarefaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author dyeimys
 */
@Controller
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping(value = {"/app/tarefa"})
    public String tarefaHome(final Tarefa tarefa) {
        return "/app/tarefa/home";
    }

    @PostMapping(value = "/app/tarefa", params = {"save"})
    public String saveTarefa(@Valid final Tarefa tarefa, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("tarefa", tarefa);
            return "/app/tarefa/home";
        }
        System.out.println("TUDO OK - AGORA CRIAR");
        tarefaService.inserir(tarefa);
        return "redirect:/app/tarefa";
    }

    @ModelAttribute("allTarefas")
    public List<Tarefa> populateVisualizarProfessor() {
        return this.tarefaService.findAll();

    }
}
