/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mais.medicos.service;

import mais.medicos.domain.Professor;
import mais.medicos.domain.Turma;

import java.util.List;

/**
 *
 * @author dfranco
 */
public interface TurmaService extends AbstractService<Turma, Integer> {

    /**
     *
     * @param professor
     * @return
     */
    public List<Turma> allOfProfessor(Professor professor);
    
}
