/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.controller;

import br.ufg.jatai.fsw.squest.controller.modelForm.QuestãoModel;
import br.ufg.jatai.fsw.squest.domain.Questionario;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dfranco
 */
@Controller
@RequestMapping("/app/questionario")
public class QuestionarioController implements Serializable {

    private static Logger log = LoggerFactory.getLogger(QuestionarioController.class.getName());


    public void inserirQuestão(String correta, QuestãoModel questaoModel){


    }
    /**
     *
     * @return
     */

    @RequestMapping(value = "/inserir")
    public String QuestoesEquipeInserir(QuestãoModel questionario) {
        return "/app/questionario/inserir";
    }
    
    /**
    *
    * @return
    */
   @RequestMapping(value = "/responder")
   public String QuestoesEquipeResponder(Questionario questionario) {
       return "/app/questionario/responder";
   }
   
   /**
   *
   * @return
   */
  @RequestMapping(value = "/pontuacao")
  public String QuestoesEquipePontuacao(Questionario questionario) {
      return "/app/questionario/pontuacao";
  }
}
