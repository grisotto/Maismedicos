/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.repository;

import br.ufg.jatai.fsw.squest.domain.Questionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author vilela
 */
public interface QuestionarioRepository extends JpaRepository<Questionario, Integer> {


    @Query("select q from  Questionario q where q.time.id=:equipeID")
    public Questionario getFromTarefaEquipe(@Param("equipeID") Integer equipeID);
}
