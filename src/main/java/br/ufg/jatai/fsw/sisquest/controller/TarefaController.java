/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.controller;

import br.ufg.jatai.fsw.sisquest.SessaoUsuario;
import br.ufg.jatai.fsw.sisquest.controller.modelForm.EtapasModel;
import br.ufg.jatai.fsw.sisquest.model.Tarefa;
import br.ufg.jatai.fsw.sisquest.model.Turma;
import br.ufg.jatai.fsw.sisquest.service.TarefaService;
import br.ufg.jatai.fsw.sisquest.service.TurmaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;
    @Autowired
    private TurmaService turmaService;
    @Autowired
    private SessaoUsuario sessaoUsuario;

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

        tarefa.setTurma(turmaService.find(tarefa.getTurma().getId()));

        tarefaService.inserir(tarefa);
        return "redirect:/app/tarefa";
    }

    @ModelAttribute("allTarefas")
    public List<Tarefa> populateVisualizarProfessor() {
        return this.tarefaService.allOfProfessor(sessaoUsuario.getProfessor());

    }

    @ModelAttribute("allTurmas")
    public List<Turma> todasTurmas() {
        System.out.println("ENTROU NO ALL TURMAS");
        return this.turmaService.allOfProfessor(sessaoUsuario.getProfessor());

    }

    @GetMapping(value = "/app/tarefa/{id}")
    public String showTurma(@PathVariable Integer id, ModelMap map, final EtapasModel etapas) {
        Tarefa find = tarefaService.find(id);
        map.addAttribute("tarefa", find);

        map.addAttribute("etapas", new EtapasModel().buildeOvjeto(find.getEtapaEventos()));

        System.out.println(id);
        return "/app/tarefa/show";
    }

    @PostMapping(value = {"/app/tarefa/etapas"}, params = {"save"})
    public String atualizaData(@Valid Integer idTarefa, @Valid EtapasModel etapas,
            final BindingResult bindingResult, final ModelMap model) {
        System.out.println("Passou aqui porra");
        System.out.println(etapas.getAguardando().getTipo());
        System.out.println(etapas.getEsperandoSubmissao().getTipo());
        System.out.println(etapas.getValidandoQuestoes().getTipo());
        System.out.println(etapas.getRespondendo().getTipo());
        System.out.println(etapas.getFinalizado().getTipo());

        Tarefa find = tarefaService.find(idTarefa);
        find.getEtapaEventos().addAll(etapas.buildeLista());

        tarefaService.atualizar(find);

        return "redirect:/app/tarefa/" + idTarefa;
    }

}
