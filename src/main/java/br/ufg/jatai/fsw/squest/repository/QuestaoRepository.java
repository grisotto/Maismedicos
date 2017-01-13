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

    @Query("select q from Questao q where q.questionario.id=:questionarioID")
    public Set<Questao> questoesDoQuestionario(@Param("questionarioID") Integer questionarioID);
}
