/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.controller;

import br.ufg.jatai.fsw.sisquest.model.Tarefa;
import br.ufg.jatai.fsw.sisquest.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
