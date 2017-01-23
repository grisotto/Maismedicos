/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.controller;

import br.ufg.jatai.fsw.squest.controller.modelForm.EtapasModel;
import br.ufg.jatai.fsw.squest.domain.Questionario;
import br.ufg.jatai.fsw.squest.domain.Tarefa;
import br.ufg.jatai.fsw.squest.domain.Turma;
import br.ufg.jatai.fsw.squest.facade.QuestionarioFacade;
import br.ufg.jatai.fsw.squest.facade.TarefaFacade;
import br.ufg.jatai.fsw.squest.service.QuestionarioService;
import br.ufg.jatai.fsw.squest.service.TarefaService;
import br.ufg.jatai.fsw.squest.service.TurmaService;
import java.util.List;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    private TarefaFacade tarefaFacade;

    @Autowired
    private QuestionarioService questionarioService;

    @Autowired
    private QuestionarioFacade questionarioFacade;

    /**
     *
     * @param tarefa
     * @return
     */
    @GetMapping(value = {"/app/tarefa"})
    public String tarefaHome(final Tarefa tarefa) {
        return "app/tarefa/home";
    }

    /**
     *
     * @param tarefa
     * @param bindingResult
     * @param model
     * @return
     */
    @PostMapping(value = "/app/tarefa", params = {"save"})
    public String saveTarefa(@Valid final Tarefa tarefa, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("tarefa", tarefa);
            return "app/tarefa/home";
        }

        tarefa.setTurma(turmaService.find(tarefa.getTurma().getId()));

        tarefaService.inserir(tarefa);

        tarefaFacade.saveTarefa(tarefa);

        return "redirect:/app/tarefa";
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
    @ModelAttribute("allTurmas")
    public List<Turma> todasTurmas() {

        return tarefaFacade.todasTurmas();

    }

    /**
     *
     * @param id
     * @param map
     * @param etapas
     * @return
     */
    @GetMapping(value = "/app/tarefa/{id}")
    public String showTurma(@PathVariable Integer id, ModelMap map, final EtapasModel etapas) {

        Tarefa find = tarefaFacade.findTarefa(id);

        map.addAttribute("tarefa", find);

//        map.addAttribute("equipe", new Equipe());
        //aqui eu tenho que pegar os dados dos grupos desta Tarefa
        map.addAttribute("etapas", new EtapasModel().buildeOvjeto(find.getEtapaEventos()));

        return "app/tarefa/show";
    }

    /**
     *
     * @param idTarefa
     * @param etapas
     * @param bindingResult
     * @param model
     * @return
     */
    @PostMapping(value = {"/app/tarefa/etapas"}, params = {"save"})
    public String atualizaData(@Valid Integer idTarefa, @Valid EtapasModel etapas,
            final BindingResult bindingResult, final ModelMap model) {

        tarefaFacade.atualizaDatasEtapas(idTarefa, etapas);

        return "redirect:/app/tarefa/" + idTarefa;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(TarefaController.class);
    @GetMapping("/app/tarefa/{idTarefa}/set/{idEtapa}")
    public String modificaEtapaAtual(@PathVariable final Integer idTarefa, @PathVariable final Integer idEtapa) {
        LOGGER.info("Entrou aqui com: \n"
                + "\nidTarefa: "+idTarefa
                + "\nidEtapa: "+idEtapa
        );
        tarefaFacade.atualizaEtapaAtual(idTarefa, idEtapa);
        Tarefa tarefa = tarefaFacade.findTarefa(idTarefa);

        if (tarefa.getEtapaAtual().isRespondendo()){
            return "redirect:/app/quiz/" + idTarefa + "/novo";
        }
        return "redirect:/app/tarefa/" + idTarefa;
    }


    @GetMapping(value = "/app/tarefa/{tarefaid}/questoes")
    public String showQuestoesTurma(@PathVariable Integer tarefaid, ModelMap map, final EtapasModel etapas) {

        Tarefa find = tarefaFacade.findTarefa(tarefaid);

        map.addAttribute("questoesturma", questionarioService.questoesDaTarefa(tarefaid));

        map.addAttribute("tarefa", find);

//        map.addAttribute("equipe", new Equipe());
        //aqui eu tenho que pegar os dados dos grupos desta Tarefa


        return "app/tarefa/questoes";
    }



}
