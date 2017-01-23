package br.ufg.jatai.fsw.squest.controller;

import br.ufg.jatai.fsw.squest.AutenticateUser;
import br.ufg.jatai.fsw.squest.configuration.SecurityConfig;
import br.ufg.jatai.fsw.squest.domain.*;
import br.ufg.jatai.fsw.squest.domain.quis.QuestaoQuiz;
import br.ufg.jatai.fsw.squest.domain.quis.Quiz;
import br.ufg.jatai.fsw.squest.domain.quis.RespotaQuestaoQuiz;
import br.ufg.jatai.fsw.squest.service.QuestaoService;
import br.ufg.jatai.fsw.squest.service.QuizService;
import br.ufg.jatai.fsw.squest.service.TarefaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by dyeimys on 21/01/17.
 */
@Controller
@RequestMapping("/app/quiz")
public class QuizController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired
    private AutenticateUser autenticateUser;

    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private QuizService quizService;

    @Autowired
    private QuestaoService questaoService;

    @GetMapping
    public String home(final Quiz quiz, ModelMap model) {
        if (autenticateUser.getUsuario().getTipoUsuario().equals(Usuario.TipoUsuario.PROFESSOR)) {
            model.addAttribute("turmas", tarefaService.allOfProfessor(autenticateUser.getProfessor()));
        }
        return "app/quiz/home";
    }

    @GetMapping("/{tarefaID}/novo")
    public String criarQuiz(@PathVariable Integer tarefaID, Model model) {
        LOGGER.info("Novo quiz, para tarefa {}", tarefaID);
        Tarefa tarefa = tarefaService.find(tarefaID);//Recuprar a tarefa
        Quiz q = new Quiz();//Inicializa o quiz
        q.setTarefa(tarefa);//Coloca Tarefa
        Set<Questao> questoes = questaoService.questoesParaQuiz(tarefaID);//Recupera as questões
        LOGGER.info("Quatidade de Questões para o Quiz: {}", questoes.size());
        q.setQuestaoQuizes(QuestaoQuiz.AjusteTecnico.create(questoes));//Coloca questões

        quizService.inserir(q);//Salva quiz
        //TODO colocar a etapa para respondendo


        model.addAttribute(String.format("msg", "Quiz adicionado \n %s", q));
//        return "redirect:/app/quiz/";
        return "redirect:/app/tarefa/" + tarefaID;

    }

    @PostMapping("/{quizID}/equipe")
    public Set<QuestaoQuiz> getQuestoes(@PathVariable("quizID") Integer quizID, @RequestBody Equipe equipe) {
        return quizService.find(quizID).questaoToEquipe(equipe);
    }

    @PostMapping("/{quizID}/responder")
    public void respostaQuestao(QuestaoQuiz questaoQuiz, Alternativa alternativa) {
        Equipe equipe = autenticateUser.getEquipe();//Requcuperando equipe
        RespotaQuestaoQuiz respotaQuestaoQuiz = new RespotaQuestaoQuiz();//Cria Obbjeto de reposta
        respotaQuestaoQuiz.setAlternativa(alternativa);//Colocando a autenrativa
        respotaQuestaoQuiz.setEquipe(equipe);//Colocando a equipe
        respotaQuestaoQuiz.setQuestao(questaoQuiz.getQuestao());

        questaoQuiz.getRespotaQuestaoQuizs().add(respotaQuestaoQuiz);//Adicionando a resposta

        questaoQuiz.getEquipeResponderam().add(equipe);



//        quizService.atualizar()




    }

    @PreAuthorize("hasAuthority('GRUPO')")
    @GetMapping("/{quizID}/responder/{questaoID}")
    public String responderQuestao(@PathVariable Integer questaoID, Model model) {

        model.addAttribute("questao", questaoService.find(questaoID));

        return "app/quiz/responder";


    }

    @PreAuthorize("hasAuthority('GRUPO')")
    @GetMapping("/{quizID}/responder")
    public String viewResponder(@PathVariable("quizID") Integer quizID, Model model) {
        //lista todas as questẽos do bagulho
        Set<QuestaoQuiz> todas = quizService.find(quizID).getQuestaoQuizes();

        //Lista apenas as questẽos que a Equipe vai responder.
        Set<QuestaoQuiz> paraEquipe = quizService.find(quizID).questaoToEquipe(autenticateUser.getEquipe());

        model.addAttribute("questoes", paraEquipe);
        model.addAttribute("quiz", quizService.find(quizID));
        LOGGER.info("Temos {} questẽos para equipe e ao todo são {}", paraEquipe,todas);

        return "app/quiz/questoes";
    }



}
