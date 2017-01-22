/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.service;

import br.ufg.jatai.fsw.squest.domain.Questao;

import java.util.Set;

/**
 *
 * @author dfranco
 */
public interface  QuestaoService extends AbstractService<Questao, Integer> {
    public Set<Questao> questoesDoQuestionario(Integer questionarioID);

    public void aceitarQuestao(Integer idQuestao);

    public void reprovarQuestao(Integer idQuestao, String motivo);

    public  Set<Questao> questoesParaQuiz(Integer tarefaID);

}
