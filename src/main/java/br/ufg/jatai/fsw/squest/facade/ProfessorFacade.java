package br.ufg.jatai.fsw.squest.facade;

import br.ufg.jatai.fsw.squest.AutenticateUser;
import br.ufg.jatai.fsw.squest.controller.AlunoController;
import br.ufg.jatai.fsw.squest.controller.ProfessorController;
import br.ufg.jatai.fsw.squest.domain.Aluno;
import br.ufg.jatai.fsw.squest.domain.Professor;
import br.ufg.jatai.fsw.squest.domain.Turma;
import br.ufg.jatai.fsw.squest.service.ProfessorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by thevilela on 08/01/17.
 */

@Component
public class ProfessorFacade {

    @Autowired
    ProfessorService professorService;

    private static Logger log = LoggerFactory.getLogger(ProfessorController.class.getName());

    @Autowired
    private AutenticateUser autenticateUser;

    /**
     * Lista todos os professores
     *
     * @return
     */

    public List<Professor> listarProfessores(){
        return professorService.findAll();
    }

    /**
     * Insere um novo professor
     *
     * @param professor
     */

    public void inserirProfessor(Professor professor){

        professorService.inserir(professor);

    }

    /**
     * Atualiza um professor específico
     *
     * @param professor
     */
    public void updateProfessor(Professor professor){

        professorService.atualizar(professor);

    }

    /**
     * Lista todas as turmas do professor
     *
     * @param professor
     * @return
     */
    public Set<Turma> turmasDoProfessor(Professor professor) {

        return new HashSet<>(professorService.find(professor).getTurmas());

    }

    public Set<Turma> turmasDoProfessor(Integer id){

        return new HashSet<>(professorService.find(id).getTurmas());

    }



}
