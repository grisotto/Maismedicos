/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.repository;

import br.ufg.jatai.fsw.squest.domain.Tarefa;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author vilela
 */
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

    @Query("select t from Tarefa t where t.turma.professor.id = ?1")
    public Set<Tarefa> findOfProfessor(Integer professor_id);
}
