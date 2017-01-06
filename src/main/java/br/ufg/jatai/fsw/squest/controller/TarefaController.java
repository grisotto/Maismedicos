/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.controller;

import br.ufg.jatai.fsw.squest.AutenticateUser;
import br.ufg.jatai.fsw.squest.controller.modelForm.EtapasModel;
import br.ufg.jatai.fsw.squest.domain.Tarefa;
import br.ufg.jatai.fsw.squest.domain.Turma;
import br.ufg.jatai.fsw.squest.facade.TarefaFacade;
import br.ufg.jatai.fsw.squest.service.TarefaService;
import br.ufg.jatai.fsw.squest.service.TurmaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author dyeimys
 */
@Controller
@PreAuthorize("hasAuthority('PROFESSOR')")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;
    @Autowired
    private TurmaService turmaService;

    @Autowired
    private AutenticateUser autenticateUser;

    @Autowired
    private TarefaFacade tarefaFacade;


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

      tarefaFacade.saveTarefa(tarefa);
        return "redirect:/app/tarefa";
    }

    @ModelAttribute("allTarefas")
    public List<Tarefa> populateVisualizarProfessor() {
        return tarefaFacade.tarefasFromProessorAuth();
    }

    @ModelAttribute("allTurmas")
    public List<Turma> todasTurmas() {

        return tarefaFacade.todasTurmas();

    }

    @GetMapping(value = "/app/tarefa/{id}")
    public String showTurma(@PathVariable Integer id, ModelMap map, final EtapasModel etapas) {
        Tarefa find = tarefaFacade.findTarefa(id);
        map.addAttribute("tarefa", find);

        map.addAttribute("etapas", new EtapasModel().buildeOvjeto(find.getEtapaEventos()));

        return "/app/tarefa/show";
    }

    @PostMapping(value = {"/app/tarefa/etapas"}, params = {"save"})
    public String atualizaData(@Valid Integer idTarefa, @Valid EtapasModel etapas,
            final BindingResult bindingResult, final ModelMap model) {



        tarefaFacade.atualizaDatasEtapas(idTarefa,etapas);

        return "redirect:/app/tarefa/" + idTarefa;
    }

}
