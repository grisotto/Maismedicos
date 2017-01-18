/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.controller;

import br.ufg.jatai.fsw.squest.AutenticateUser;
import br.ufg.jatai.fsw.squest.controller.modelForm.QuestãoModel;
import br.ufg.jatai.fsw.squest.domain.Questao;
import br.ufg.jatai.fsw.squest.domain.Questionario;
import br.ufg.jatai.fsw.squest.domain.Tarefa;
import br.ufg.jatai.fsw.squest.facade.QuestionarioFacade;
import br.ufg.jatai.fsw.squest.repository.QuestionarioRepository;
import br.ufg.jatai.fsw.squest.service.QuestaoService;
import br.ufg.jatai.fsw.squest.service.QuestionarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dfranco
 */
@Controller
@RequestMapping("/app/questionario")
public class QuestionarioController implements Serializable {

    private static Logger log = LoggerFactory.getLogger(QuestionarioController.class.getName());

    @Autowired
    private AutenticateUser user;

    @Autowired
    private QuestionarioFacade questionarioFacade;

    @Autowired
    private QuestionarioRepository questionarioRepository;

    @Autowired
    private QuestionarioService questionarioService;

    @Autowired
    private QuestaoService questaoService;

    @PostMapping("/addQuestao")
    public String inserirQuestão(final String correto, final QuestãoModel questaoModel,
            final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("questaoModel", questaoModel);
            model.addAttribute("correto", "C");
            return "redirect:/app/questionario/inserir";

        }

        log.info("Entrda de Dados no @Controller");
        log.info("Equipe: " + user.getEquipe());
        log.info("Tarefa: " + user.getEquipe().getTarefa());
        log.info("Descrição: " + questaoModel.getDescricao());
        log.info("Alternativa A: " + questaoModel.getAlternativaA().getDescricao());
        log.info("Alternativa B: " + questaoModel.getAlternativaB().getDescricao());
        log.info("Alternativa C: " + questaoModel.getAlternativaC().getDescricao());
        log.info("Alternativa D: " + questaoModel.getAlternativaD().getDescricao());
        log.info("Alternativa E: " + questaoModel.getAlternativaE().getDescricao());
        log.info("CORRETA: " + correto);

        if (correto.equals("A")) {
            questaoModel.getAlternativaA().setCorreto(true);
        } else if (correto.equals("B")) {
            questaoModel.getAlternativaB().setCorreto(true);
        } else if (correto.equals("C")) {
            questaoModel.getAlternativaC().setCorreto(true);
        } else if (correto.equals("D")) {
            questaoModel.getAlternativaD().setCorreto(true);
        } else if (correto.equals("E")) {
            questaoModel.getAlternativaE().setCorreto(true);
        }

        //Gerar a questão por meio do modelo
        Questao questao = questaoModel.getQuestao();

        //Pegar o questionario dessa equipe
        Questionario questionario = questionarioRepository.getFromTarefaEquipe(user.getEquipe().getId());

        //Verificar se o questionario é null, se for null é porque ainda não existe um questionario
        if (questionario == null) {//Então Tem uqe criar um questionario
            questionario = new Questionario();//Coloca uma instancia nele 
            questionario.setTime(user.getEquipe());//Coloca a euipe
            questionario.setTarefa(user.getEquipe().getTarefa());//Coloca a Tarefa
            questionario.setquestions(new ArrayList<>());//Inicia as Questões dele
            
           
        }
        questao.setQuestionario(questionario);
        questionario.getQuestoes().add(questao);//Adiciona a questão que foi recuperada
        questaoService.inserir(questao);// Insere no banco o questionario
//        questaoService.inserir(questao);//Agora insere 

        return "redirect:/app/";
    }
    @PostMapping ("{idQuestao}/ativar")
    public String ativarQuestao (@PathVariable ("idQuestao") Integer idQuestao, @Valid Tarefa tarefa){
        questaoService.ativarQuestao(idQuestao);


        return "redirect:/app/tarefa/" + tarefa.getId() + "/questoes";

    }

    /**
     * @return
     */
    @RequestMapping(value = "/inserir")
    public String QuestoesEquipeInserir(QuestãoModel questionario) {
        return "app/questionario/inserir";
    }

    /**
     * @return
     */
    @RequestMapping(value = "/responder")
    public String QuestoesEquipeResponder(Questionario questionario) {
        return "app/questionario/responder";
    }

    /**
     * @return
     */
    @RequestMapping(value = "/pontuacao")
    public String QuestoesEquipePontuacao(Questionario questionario) {
        return "app/questionario/pontuacao";
    }


    @GetMapping(value = "/{id}")
    public String showTurma(@PathVariable Integer id, ModelMap map) {

        map.addAttribute("questao", questaoService.find(id));



        return "app/questionario/show";
    }




}
