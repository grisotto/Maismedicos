/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.service;

import br.ufg.jatai.fsw.squest.domain.Questionario;

import java.util.List;

/**
 *
 * @author vilela
 */
public interface QuestionarioService extends AbstractService<Questionario, Integer> {

    public List<Questionario> questoesDaTarefa(Integer tarefaID);

    public List<Questionario> questoesDasOutrasEquipes(Integer tarefaID, Integer equipeID );


    
}
