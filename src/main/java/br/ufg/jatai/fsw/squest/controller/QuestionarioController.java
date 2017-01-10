/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.controller;

import br.ufg.jatai.fsw.squest.controller.modelForm.QuestãoModel;
import br.ufg.jatai.fsw.squest.domain.Questionario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

/**
 * @author dfranco
 */
@Controller
@RequestMapping("/app/questionario")
public class QuestionarioController implements Serializable {

    private static Logger log = LoggerFactory.getLogger(QuestionarioController.class.getName());


    @PostMapping("/addQuestao")
    public String inserirQuestão(String correto, QuestãoModel questaoModel) {
        log.info("CORRETA: " + correto);
        log.info("Alternativa A: " + questaoModel.getAlternativaA().getDescricao());
        log.info("Alternativa B: " + questaoModel.getAlternativaB().getDescricao());
        log.info("Alternativa C: " + questaoModel.getAlternativaC().getDescricao());
        log.info("Alternativa D: " + questaoModel.getAlternativaD().getDescricao());
        log.info("Alternativa E: " + questaoModel.getAlternativaE().getDescricao());
        return "redirect:/app/questionario/inserir";
    }

    /**
     * @return
     */

    @RequestMapping(value = "/inserir")
    public String QuestoesEquipeInserir(QuestãoModel questionario) {
        return "/app/questionario/inserir";
    }

    /**
     * @return
     */
    @RequestMapping(value = "/responder")
    public String QuestoesEquipeResponder(Questionario questionario) {
        return "/app/questionario/responder";
    }

    /**
     * @return
     */
    @RequestMapping(value = "/pontuacao")
    public String QuestoesEquipePontuacao(Questionario questionario) {
        return "/app/questionario/pontuacao";
    }
}
