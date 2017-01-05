/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.facade;

import br.ufg.jatai.fsw.squest.domain.Aluno;
import br.ufg.jatai.fsw.squest.domain.Professor;
import br.ufg.jatai.fsw.squest.domain.Tarefa;
import br.ufg.jatai.fsw.squest.domain.Turma;
import br.ufg.jatai.fsw.squest.service.AlunoService;
import br.ufg.jatai.fsw.squest.service.TarefaService;
import br.ufg.jatai.fsw.squest.service.TurmaService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
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
        return this.turmasOfProfessor(null);
    }

    public Turma createTurma(Turma turma) {
        turma.setProfessor(null);
        return turmaService.inserir(turma);
    }

    public Turma findTurma(Integer id) {
        return turmaService.find(id);
    }

    public Turma insertAluno(Turma turma, Aluno aluno) {
        turma.getAlunos().add(aluno);
        return turmaService.atualizar(turma);
    }

    public Turma insertAluno(Integer idTurma, Integer idAluno) {
        return this.insertAluno(
                turmaService.find(idTurma),
                alunoService.find(idAluno)
        );
    }

    public List<Tarefa> tarefasOfProfessor() {
        return tarefaService.allOfProfessor(null);
    }

}
