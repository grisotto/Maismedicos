/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.service;

import br.ufg.jatai.fsw.sisquest.model.Professor;
import br.ufg.jatai.fsw.sisquest.model.Tarefa;
import br.ufg.jatai.fsw.sisquest.model.Turma;
import java.util.List;

/**
 *
 * @author dfranco
 */
public interface TarefaService extends AbstractService<Tarefa, Integer> {

    public List<Tarefa> allOfProfessor(Professor professor);

}
