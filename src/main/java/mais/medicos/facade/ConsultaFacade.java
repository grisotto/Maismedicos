/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mais.medicos.facade;

import mais.medicos.AutenticateUser;
import mais.medicos.domain.Aluno;
import mais.medicos.service.AlunoService;
import mais.medicos.service.TarefaService;
import mais.medicos.service.TurmaService;

import java.io.Serializable;
import java.util.List;

import mais.medicos.domain.Professor;
import mais.medicos.domain.Tarefa;
import mais.medicos.domain.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author dfranco
 */
@Component
public class TurmaFacade implements Serializable {

    @Autowired
    private TurmaService turmaService;
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private TarefaService tarefaService;
    @Autowired
    private AutenticateUser autenticateUser;

    /**
     *
     */
    public TurmaFacade() {

    }

    /**
     *
     * @param professor
     * @return
     * @deprecated
     */
    @Deprecated
    public List<Turma> turmasOfProfessor(Professor professor) {
        return turmaService.allOfProfessor(professor);
    }

    /**
     * Turmas que o professor é "DONO"
     *
     * @return
     */

    public List<Turma> turmasOfProfessor() {
        return this.turmasOfProfessor(autenticateUser.getProfessor());
    }

    /**
     *
     * @param turma
     * @return
     */
    public Turma createTurma(Turma turma) {
        turma.setProfessor(autenticateUser.getProfessor());
        return turmaService.inserir(turma);
    }

    /**
     *
     * @param id
     * @return
     */
    public Turma findTurma(Integer id) {
        return turmaService.find(id);
    }

    /**
     *
     * @param turma
     * @param aluno
     * @return
     */
    public Turma insertAluno(Turma turma, Aluno aluno) {
        turma.getAlunos().add(aluno);
        return turmaService.atualizar(turma);
    }

    /**
     *
     * @param idTurma
     * @param idAluno
     * @return
     */
    public Turma insertAluno(Integer idTurma, Integer idAluno) {
        return this.insertAluno(
                turmaService.find(idTurma),
                alunoService.find(idAluno)
        );
    }

    /**
     *
     * @return
     */
    public List<Tarefa> tarefasOfProfessor() {
        return tarefaService.allOfProfessor(autenticateUser.getProfessor());
    }

}
