/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.facade;

import br.ufg.jatai.fsw.squest.AutenticateUser;
import br.ufg.jatai.fsw.squest.domain.Aluno;
import br.ufg.jatai.fsw.squest.domain.Equipe;
import br.ufg.jatai.fsw.squest.service.AlunoService;
import br.ufg.jatai.fsw.squest.service.EquipeService;
import br.ufg.jatai.fsw.squest.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author dyeimys
 */
@Component
public class EquipeFacade {

    @Autowired
    private EquipeService equipeService;
    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private AutenticateUser autenticateUser;
    @Autowired
    private AlunoService alunoService;

    /**
     * Periste um nova tarefa
     *
     * @param e
     */
    public void adicionaEquipe(Equipe e) {
        equipeService.inserir(e);
    }

    /**
     * Adiciona um aluno à equipe
     *
     * @param aluno
     * @param equipe
     */
    public void addAluno(Aluno aluno, Equipe equipe) {

        equipe.add(aluno);
        aluno.getTeams().add(equipe);
//        equipeService.atualizar(equipe);
        alunoService.atualizar(aluno);
    }

    /**
     * Lista todos alunos de uma determinada equipe
     *
     * @param equipe
     * @return
     */
    public List<Aluno> alunosFromEquipe(Equipe equipe) {
        return equipeService.find(equipe.getId()).getAlunos();

    }

    /**
     * Listagem das Equipes do professor.
     *
     * @return
     */
    public List<Equipe> todasEquipesDoProfessor() {
        return this.equipeService.equipesDoProfessor(autenticateUser.getProfessor().getId());

    }

    /**
     * @param id
     * @return
     */
    public Equipe findEquipe(Integer id) {
        return equipeService.find(id);
    }

    public List<Aluno> alunosElegiveisParaEquipe(Integer turmaID) {
        return alunoService.alunosElegiveisParaEquipe(turmaID);

    }
}
