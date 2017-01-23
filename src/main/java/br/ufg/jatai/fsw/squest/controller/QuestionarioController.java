/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.controller;

import br.ufg.jatai.fsw.squest.AutenticateUser;
import br.ufg.jatai.fsw.squest.controller.modelForm.QuestaoModel;
import br.ufg.jatai.fsw.squest.domain.Questao;
import br.ufg.jatai.fsw.squest.domain.Questionario;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;
import java.util.ArrayList;

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
    public String inserirQuestão(final String correto, final QuestaoModel questaoModel,
                                 final BindingResult bindingResult, final ModelMap model) {

        //Verificar, se pode adicionar
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
        //Colocando como aguardando
        questao.setSituacaoQuestao(Questao.SituacaoQuestao.AGUARDANDO);

        //Pegar o questionario dessa equipe
        Questionario questionario = questionarioRepository.getFromTarefaEquipe(user.getEquipe().getId());

        //Verificar se o questionario é null, se for null é porque ainda não existe um questionario
        if (questionario == null) {//Então Tem uqe criar um questionario
            questionario = new Questionario();//Coloca uma instancia nele 
            questionario.setTime(user.getEquipe());//Coloca a euipe
            questionario.setTarefa(user.getEquipe().getTarefa());//Coloca a Tarefa
            questionario.setquestions(new ArrayList<Questao>());//Inicia as Questões dele

        }
        questao.setQuestionario(questionario);
        questionario.getQuestoes().add(questao);//Adiciona a questão que foi recuperada
        questaoService.inserir(questao);// Insere no banco o questionario
//        questaoService.inserir(questao);//Agora insere 

        return "redirect:/app/";
    }

    @PostMapping("{questaoID}/aprovar")
    public String aprovarQuestao(@PathVariable("questaoID") Integer idQuestao) {
        Questao q = questaoService.aprovarQuestao(idQuestao);

        return "redirect:/app/tarefa/" + q.getQuestionario().getTarefa().getId() + "/questoes";

    }

    @GetMapping("{questaoID}/remover")        //TODO colocar como post
    public String removeQuestao(@PathVariable("questaoID") Integer questaoID) {
        Questao questao = questaoService.find(questaoID);
        log.info("Removendo questão [id: {}, Descrição: {}", questao.getId(), questao.getQuestion());
        questaoService.apagar(questao);
        return "redirect:/app/";
    }

    @PostMapping("{questaoID}/reprovar")
    public String reprovarQuestao(@PathVariable("questaoID") Integer idQuestao) {
        Questao q = questaoService.reprovarQuestao(idQuestao, "Mensagem");

        return "redirect:/app/tarefa/" + q.getQuestionario().getTarefa().getId() + "/questoes";

    }

    /**
     * @return
     */
    @RequestMapping(value = "/inserir")
    public String QuestoesEquipeInserir(QuestaoModel questionario) {
        Integer qntQuestoes = user.getEquipe().getQuestionario() != null ? questaoService.questoesDoQuestionario(user.getEquipe().getQuestionario().getId()).size() : 0;
        Integer maxQuestoes = user.getEquipe().getTarefa().getTamanhoQuestoes();

        if (qntQuestoes < maxQuestoes) {
            return "app/questionario/inserir";

        } else {
            throw new ArrayIndexOutOfBoundsException(String.format("O limite máximo de questões permitidas são: %d", maxQuestoes));
        }

    }

    /**
     * @return
     */
    @GetMapping(value = "/responder/{questaoID}")
    public String QuestoesEquipeResponder(@PathVariable Integer questaoID, ModelMap map) {

        map.addAttribute("questao", questaoService.find(questaoID));

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
