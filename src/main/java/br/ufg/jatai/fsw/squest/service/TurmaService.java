/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.service;

import br.ufg.jatai.fsw.squest.domain.Professor;
import br.ufg.jatai.fsw.squest.domain.Turma;
import java.util.List;

/**
 *
 * @author dfranco
 */
public interface TurmaService extends AbstractService<Turma, Integer> {

    public List<Turma> allOfProfessor(Professor professor);
    
}
