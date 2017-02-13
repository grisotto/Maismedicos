/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.repository;

import br.ufg.jatai.fsw.squest.domain.quis.RespotaQuestaoQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RespotaQuestaoQuizRepository extends JpaRepository<RespotaQuestaoQuiz, Integer> {

    public List<RespotaQuestaoQuiz> findAllByEquipe_Id(Integer equipeID);

    public List<RespotaQuestaoQuiz> findAllByQuestao_Id(Integer questaoID);
}
