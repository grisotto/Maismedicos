/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.controller;

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
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

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
     * @param equipe
     * @param bindingResult
     * @param model
     * @return
     */
    @PostMapping(params = {"save"})
    public String createEquipe(@Valid final Equipe equipe, final BindingResult bindingResult, final ModelMap model) {
//Validando equipe unica
        if(equipeFacade.existeEquipe(equipe.getNome())){
            bindingResult.addError(new FieldError("equipe","nome","A Equipe já existe"));
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("equipe", equipe);
            return "/app/equipe/home";

        }

        equipeFacade.adicionaEquipe(equipe);

        return "redirect:/app/equipe";

    }

    /**
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
     * @param aluno
     * @param equipe
     * @param bindingResult
     * @param model
     * @return
     */
    @PostMapping(value = "/addAluno")
    public String addAluno(@Valid final Aluno aluno, @Valid final Equipe equipe, final BindingResult bindingResult, final ModelMap model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("equipe", equipe);
            model.addAttribute("aluno", aluno);
        }

        equipeFacade.addAluno(aluno, equipe);
        return "redirect:/app/equipe/" + equipe.getId();
    }

    /**
     * @param id
     * @param map
     * @return
     */
    @GetMapping(value = "/{id}")
    public String showEquipe(@PathVariable Integer id,final ModelMap map) {
        map.clear();
        map.addAttribute("equipe", equipeFacade.findEquipe(id));

        Equipe equipe = equipeFacade.findEquipe(id);


        List<Aluno> alunos = equipeFacade.alunosElegiveisParaEquipe(equipe.getTarefa().getTurma().getId());
        //TODO: Aqui esta errado, precisa de todos os alunos que estao na turma desta tarefa e que nao estao em nenhuma tarefa
        map.addAttribute("todosAlunos", alunos);
        log.info("ALUNOS: " + alunos.size() + "\n" +
                "" + alunos);
        return "/app/equipe/show";
    }

    /**
     * @return
     */
    @ModelAttribute("allTarefas")
    public List<Tarefa> populateVisualizarProfessor() {
        return tarefaFacade.tarefasFromProessorAuth();
    }

    /**
     * @return
     */
    @ModelAttribute("allEquipes")
    public List<Equipe> populateVisualizarEquipesProfessor() {
        //Ela esta errada. Eu sei, fiz apenas para continuar fazendo as views
        return equipeFacade.todasEquipesDoProfessor();
    }

}
