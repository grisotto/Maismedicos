/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.repository;

import br.ufg.jatai.fsw.squest.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author vilela
 */
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    public Aluno findByEmail(String email);

    public List<Aluno> findAllByOrderByNomeAsc();

    public Aluno findByMatricula(String matricula);


    @Query("SELECT a1 FROM Aluno  a1 INNER  JOIN a1.turmas AS t1 " +
            "WHERE  t1.id = :turmaID AND a1.id NOT IN " +
            "(SELECT a2.id FROM Aluno a2 " +
            "INNER JOIN a2.equipes as e2 " +
            "INNER JOIN e2.tarefa AS t2 where t2.id=:tarefaID)")
    public List<Aluno> alunosElegiveisParaEquipe(@Param("turmaID") Integer turmaID, @Param("tarefaID") Integer tarefaID);
}
