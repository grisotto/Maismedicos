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

        return alunoService.findAll();

    }


    public void inserirAluno(Aluno aluno){

        alunoService.inserir(aluno);

    }

    public void updateAluno(Aluno aluno){

        alunoService.atualizar(aluno);

    }


    public Set<Equipe> equipesDoAluno(Aluno aluno){

        return new HashSet<>(alunoService.find(aluno).getTeams());

    }

    public Set<Equipe> equipesDoAluno(Integer id){

        return new HashSet<>(alunoService.find(id).getTeams());

    }

    public Set<Turma> turmasDoAluno(Aluno aluno){

        return new HashSet<>(alunoService.find(aluno).getTurmas());

    }

    public Set<Turma> turmasDoAluno(Integer id){

        return new HashSet<>(alunoService.find(id).getTurmas());

    }
}
