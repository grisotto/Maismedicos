/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.service;


import br.ufg.jatai.fsw.squest.domain.quis.RespotaQuestaoQuiz;

import java.util.List;


public interface RespotaQuestaoQuizService extends AbstractService<RespotaQuestaoQuiz, Integer> {


    public List<RespotaQuestaoQuiz> findAllByEquipe_Id(Integer equipeID);

    public List<RespotaQuestaoQuiz> findAllByQuestao_Id(Integer equipeID);
}
