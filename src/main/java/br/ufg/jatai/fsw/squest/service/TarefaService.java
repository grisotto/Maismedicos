/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.service;

import br.ufg.jatai.fsw.squest.domain.Professor;
import br.ufg.jatai.fsw.squest.domain.Tarefa;
import java.util.List;

/**
 *
 * @author dfranco
 */
public interface TarefaService extends AbstractService<Tarefa, Integer> {

    /**
     *
     * @param professor
     * @return
     */
    public List<Tarefa> allOfProfessor(Professor professor);


}
