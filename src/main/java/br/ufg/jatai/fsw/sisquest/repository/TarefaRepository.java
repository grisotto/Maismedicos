/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.repository;

import br.ufg.jatai.fsw.sisquest.model.Pessoa;
import br.ufg.jatai.fsw.sisquest.model.Tarefa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author vilela
 */
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

    @Query("select t from Tarefa t where t.turma.professor.id = ?1")
    public List<Tarefa> findOfProfessor(Integer professor_id);
}
