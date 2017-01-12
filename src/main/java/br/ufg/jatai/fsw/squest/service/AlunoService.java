/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.service;

import br.ufg.jatai.fsw.squest.domain.Aluno;

/**
 *
 * @author vilela
 */
public interface AlunoService extends AbstractService<Aluno, Integer> {

    public Aluno findByEmail(String email);
    public Aluno findByMatricula(String matricula);
}
