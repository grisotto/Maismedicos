/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.service;

import br.ufg.jatai.fsw.squest.domain.Questao;
import br.ufg.jatai.fsw.squest.domain.quis.QuestaoQuiz;

import java.util.Set;


public interface QuestaoQuizService extends AbstractService<QuestaoQuiz, Integer> {

    public QuestaoQuiz findByQuestaoId(Integer id);


}
