/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.repository;

import br.ufg.jatai.fsw.squest.domain.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *
 * @author vilela
 */
public interface EquipeRepository extends JpaRepository<Equipe, Integer> {
    @Query("select e from Equipe e where e.tarefa.turma.professor.id = :professorID")

    public List<Equipe> equipesDoProfessor(Integer professorID);
}
