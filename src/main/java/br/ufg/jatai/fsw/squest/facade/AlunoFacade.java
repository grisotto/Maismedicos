package br.ufg.jatai.fsw.squest.facade;

import br.ufg.jatai.fsw.squest.AutenticateUser;
import br.ufg.jatai.fsw.squest.controller.AlunoController;
import br.ufg.jatai.fsw.squest.domain.Aluno;
import br.ufg.jatai.fsw.squest.domain.Equipe;
import br.ufg.jatai.fsw.squest.domain.Turma;
import br.ufg.jatai.fsw.squest.service.AlunoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Component;

/**
 * Created by thevilela on 07/01/17.
 */
@Component
public class AlunoFacade {

    @Autowired
    private AlunoService alunoService;

    private static Logger log = LoggerFactory.getLogger(AlunoController.class.getName());

    @Autowired
    private AutenticateUser autenticateUser;

    /**
     * Lista todos os alunos cadastrados
     *
     *
     */
    public List<Aluno> listarAlunos() {
        log.trace("O usuário " + autenticateUser.getUsuario() + "está listando todos os alunos");

        return alunoService.findAll();

    }

    /**
     * Insere um novo aluno
     *
     * @param aluno
     */
    public void inserirAluno(Aluno aluno) {

        log.trace("O usuário " + autenticateUser.getUsuario() + "está adicionando o aluno: " + aluno.getNome());

        alunoService.inserir(aluno);

    }

    /**
     * Atualiza o aluno
     *
     * @param aluno
     */
    public void updateAluno(Aluno aluno) {

        log.trace("O usuário " + autenticateUser.getUsuario() + "está atualizando o aluno: " + aluno.getNome());

        alunoService.atualizar(aluno);

    }

    /**
     * Listam as equipes que determinado aluno está inserido
     *
     * @param aluno
     * @return 
     *
     */
    public Set<Equipe> equipesDoAluno(Aluno aluno) {

        log.trace("O usuário " + autenticateUser.getUsuario() + "está listando as equipes do aluno: " + aluno.getNome());

        return new HashSet<>(alunoService.find(aluno).getTeams());

    }

    public Set<Equipe> equipesDoAluno(Integer id) {

        log.trace("O usuário " + autenticateUser.getUsuario() + "está listando as equipes do aluno: " + alunoService.find(id).getNome());

        return new HashSet<>(alunoService.find(id).getTeams());

    }

    /**
     * Listam as turmas que o aluno está inserido
     *
     * @param aluno
     *
     */
    public Set<Turma> turmasDoAluno(Aluno aluno) {

        log.trace("O usuário " + autenticateUser.getUsuario() + "está listando as turmas do aluno: " + aluno.getNome());

        return new HashSet<>(alunoService.find(aluno).getTurmas());

    }

    public Set<Turma> turmasDoAluno(Integer id) {

        log.trace("O usuário " + autenticateUser.getUsuario() + "está listando as turmas do aluno: " + alunoService.find(id).getNome());

        return new HashSet<>(alunoService.find(id).getTurmas());

    }
    public boolean emailExist(String email) {
        return alunoService.findByEmail(email)!=null;
    }
    public boolean existMatricula(String matricula) {
        return alunoService.findByMatricula(matricula)!=null;
    }

}
