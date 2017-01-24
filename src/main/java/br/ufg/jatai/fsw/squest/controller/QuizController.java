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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by dyeimys on 21/01/17.
 */
@Controller
@RequestMapping("/app/quiz")
//TODO Criar fachada para essas ações
//TODO Colocar os metodos de acesso a grupo tudo como post, evitando PathVariable
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

    private static Logger log = LoggerFactory.getLogger(QuestionarioController.class.getName());

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
        //TODO Passar passar a lógica para o local correto
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

    @PostMapping("/{quizID}/responder/{questaoID}")//TODO colocar como post o QuestãoID porque os cara vão mecher com essas URLs
    public String respostaQuestao(QuestaoQuiz questaoQuiz, Alternativa alternativaSelecionada, final BindingResult bindingResult , final String alternativa,@PathVariable Integer quizID ) {


        if (bindingResult.hasErrors()) {

        }
        log.info("Entrda de Dados no @Controller");
        log.info("Equipe: " + autenticateUser.getEquipe());
        log.info("Alternativa: " + alternativaSelecionada.getDescricao());
        log.info("Alternativaa: " + alternativa);


        Equipe equipe = autenticateUser.getEquipe();//Requcuperando equipe
        RespotaQuestaoQuiz respotaQuestaoQuiz = new RespotaQuestaoQuiz();//Cria Obbjeto de reposta
        respotaQuestaoQuiz.setAlternativa(alternativaSelecionada);//Colocando a autenrativa

        respotaQuestaoQuiz.setEquipe(equipe);//Colocando a equipe
        respotaQuestaoQuiz.setQuestao(questaoQuiz.getQuestao());

//        questaoQuiz.getRespotaQuestaoQuizs().add(respotaQuestaoQuiz);//Adicionando a resposta

        questaoQuiz.getEquipeResponderam().add(equipe);



//        quizService.atualizar()

        return "redirect:/app/quiz/"+ quizID +"/responder/";


    }

    @PreAuthorize("hasAuthority('GRUPO')")
    @GetMapping("/{quizID}/responder/{questaoID}")//TODO Mover para post -  REMOVER PathVariable - Aqui o pessoal vai ficar brincando com URL, e para não ter que tratar isso é bom trocar
    public String responderQuestao(@PathVariable Integer questaoID, @PathVariable Integer quizID, Model model) {
        model.addAttribute("quiz", quizService.find(quizID));
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