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

    public Aluno findByMatricula(String matricula);
//
//    @Query("select a from Aluno a inner join a.turmas as turmaAlunos where turmaAlunos.id = :turmaID " +
//            "and a.id not in " +
//            "(" +
//            "select b.id from Aluno b " +
//            "inner join b.equipes as alunoEquipe " +
//            "where alunoEquipe.tarefa.turma.id= :turmaID" +
//            ")" +
//            "GROUP BY a.nome")
    @Query("select a from Aluno  a left outer join a.equipes as equipes inner join a.turmas as turmas " +
            "where equipes.id IS NULL  and turmas.id= :turmaID")
    public List<Aluno> alunosElegiveisParaEquipe(@Param("turmaID") Integer turmaID);
}
