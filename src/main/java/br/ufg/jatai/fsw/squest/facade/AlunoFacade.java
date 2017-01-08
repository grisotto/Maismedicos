package br.ufg.jatai.fsw.squest.facade;

import br.ufg.jatai.fsw.squest.AutenticateUser;
import br.ufg.jatai.fsw.squest.controller.AlunoController;
import br.ufg.jatai.fsw.squest.controller.EquipeController;
import br.ufg.jatai.fsw.squest.domain.Aluno;
import br.ufg.jatai.fsw.squest.domain.Equipe;
import br.ufg.jatai.fsw.squest.domain.Turma;
import br.ufg.jatai.fsw.squest.service.AlunoService;
import br.ufg.jatai.fsw.squest.service.AlunoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by thevilela on 07/01/17.
 */
public class AlunoFacade {

    @Autowired
    private AlunoService alunoService;

    private static Logger log = LoggerFactory.getLogger(AlunoController.class.getName());

    @Autowired
    private AutenticateUser autenticateUser;

    public List<Aluno> listarAlunos(){

        log.trace("O usuário " + autenticateUser.getUsuario() + "está listando todos os alunos");

        return alunoService.findAll();

    }


    public void inserirAluno(Aluno aluno){

        log.trace("O usuário " + autenticateUser.getUsuario() + "está adicionando o aluno: " + aluno.getNome());

        alunoService.inserir(aluno);

    }

    public void updateAluno(Aluno aluno){

        log.trace("O usuário " + autenticateUser.getUsuario() + "está atualizando o aluno: " + aluno.getNome());

        alunoService.atualizar(aluno);

    }


    public Set<Equipe> equipesDoAluno(Aluno aluno){

        log.trace("O usuário " + autenticateUser.getUsuario() + "está listando as equipes do aluno: " + aluno.getNome());

        return new HashSet<>(alunoService.find(aluno).getTeams());

    }

    public Set<Equipe> equipesDoAluno(Integer id){

        log.trace("O usuário " + autenticateUser.getUsuario() + "está listando as equipes do aluno: " + alunoService.find(id).getNome());

        return new HashSet<>(alunoService.find(id).getTeams());

    }

    public Set<Turma> turmasDoAluno(Aluno aluno){

        log.trace("O usuário " + autenticateUser.getUsuario() + "está listando as turmas do aluno: " + aluno.getNome());

        return new HashSet<>(alunoService.find(aluno).getTurmas());

    }

    public Set<Turma> turmasDoAluno(Integer id){

        log.trace("O usuário " + autenticateUser.getUsuario() + "está listando as turmas do aluno: " + alunoService.find(id).getNome());

        return new HashSet<>(alunoService.find(id).getTurmas());

    }
}
