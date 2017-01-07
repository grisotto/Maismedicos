/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.repository;

import br.ufg.jatai.fsw.squest.domain.Turma;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author vilela
 */
public interface TurmaRepository extends JpaRepository<Turma, Integer>, Serializable {

    @Query("select t from Turma t where t.professor.id = ?1")
    public List<Turma> findOfProfessor(Integer professor_id);

}