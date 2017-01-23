/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.repository;

import br.ufg.jatai.fsw.squest.domain.Questao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

/**
 * @author vilela
 */
public interface QuestaoRepository extends JpaRepository<Questao, Integer> {

    /**
     *        AGUARDANDO, APROVADO, REPROVADO;
     * @param tarefaID
     * @return
     */
    @Query("SELECT q FROM Questao q WHERE q.questionario.tarefa.id=:tarefaID AND q.situacaoQuestao=:situacaoQuestao")
    public Set<Questao> questoesPorSituacao(@Param("tarefaID") Integer tarefaID, @Param("situacaoQuestao") Questao.SituacaoQuestao situacaoQuestao);


    @Query("select q from Questao q where q.questionario.id=:questionarioID")
    public Set<Questao> questoesDoQuestionario(@Param("questionarioID") Integer questionarioID);
}
