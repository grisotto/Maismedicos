/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.controller;

import java.io.Serializable;
import java.util.List;

import br.ufg.jatai.fsw.squest.domain.Aluno;
import br.ufg.jatai.fsw.squest.domain.Equipe;
import br.ufg.jatai.fsw.squest.domain.Tarefa;
import br.ufg.jatai.fsw.squest.facade.EquipeFacade;
import br.ufg.jatai.fsw.squest.facade.TarefaFacade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author dfranco
 */
@Controller
@RequestMapping("/app/equipe")
public class EquipeController implements Serializable {

    private static Logger log = LoggerFactory.getLogger(EquipeController.class.getName());

    @Autowired
    private EquipeFacade equipeFacade;

    @Autowired
    private TarefaFacade tarefaFacade;

    /**
     * @return
     */
    @GetMapping()
    public String equipeHome(final Equipe equipe) {
        return "/app/equipe/home";
    }

    /**
     *
     * @param equipe
     * @param bindingResult
     * @param model
     * @return
     */
    @PostMapping(params = {"save"})
    public String createEquipe(@Valid final Equipe equipe, final BindingResult bindingResult, final ModelMap model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("equipe", equipe);
        }

        equipeFacade.adicionaEquipe(equipe);

        return "redirect:/app/equipe";

    }

    /**
     *
     * @param equipe
     * @param bindingResult
     * @param model
     * @return
     */
    @PostMapping(params = {"modal"})
    public String createEquipeModal(@Valid final Equipe equipe, final BindingResult bindingResult, final ModelMap model) {
        log.info("Acessando Equipes");
        if (bindingResult.hasErrors()) {
            model.addAttribute("equipe", equipe);
        }
        log.info("Equipe: " + equipe.getNome());
        log.info("Tarefa: " + equipe.getTarefa());

        equipeFacade.adicionaEquipe(equipe);
        //deve retornar para a mesma pagina, /app/tarefa/{equipe.tarefa.id}
        return "redirect:/app/tarefa/" + equipe.getTarefa().getId();

    }

    /**
     *
     * @param aluno
     * @param equipe
     * @param bindingResult
     * @param model
     * @return
     */
    @PostMapping(value = "/addAluno")
    public String addAluno(@Valid final Aluno aluno, @Valid final Equipe equipe, final BindingResult bindingResult, final ModelMap model) {
        log.info("ENTROU veio aluno: " + aluno);
        log.info("ENTROU veio Equipe: " + equipe);
        if (bindingResult.hasErrors()) {
            model.addAttribute("equipe", equipe);
            model.addAttribute("aluno", aluno);
        }

        equipeFacade.addAluno(aluno,equipe);
        return "redirect:/app/equipe/" + 1;
    }

    /**
     *
     * @param id
     * @param map
     * @return
     */
    @GetMapping(value = "/{id}")
    public String showEquipe(@PathVariable Integer id, ModelMap map) {

        map.addAttribute("equipe", equipeFacade.findEquipe(id));

        Equipe equipe = equipeFacade.findEquipe(id);

        //TODO: Aqui esta errado, precisa de todos os alunos que estao na turma desta tarefa e que nao estao em nenhuma tarefa
        map.addAttribute("todosAlunos", equipeFacade.alunosFromEquipe(equipe));

        return "/app/equipe/show";
    }

    /**
     *
     * @return
     */
    @ModelAttribute("allTarefas")
    public List<Tarefa> populateVisualizarProfessor() {
        return tarefaFacade.tarefasFromProessorAuth();
    }

    /**
     *
     * @return
     */
    @ModelAttribute("allEquipes")
    public List<Equipe> populateVisualizarEquipesProfessor() {
        //Ela esta errada. Eu sei, fiz apenas para continuar fazendo as views
        return equipeFacade.todasEquipes();
    }

}
