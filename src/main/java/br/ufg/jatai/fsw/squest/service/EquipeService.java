/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.service;

import br.ufg.jatai.fsw.squest.domain.Equipe;

import java.util.List;

/**
 *
 * @author dfranco
 */
public interface EquipeService extends AbstractService<Equipe, Integer> {

    public List<Equipe> equipesDoProfessor(Integer professorID);
    
}
