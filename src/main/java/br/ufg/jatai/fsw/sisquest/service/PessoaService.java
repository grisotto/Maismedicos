/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.service;

import br.ufg.jatai.fsw.sisquest.model.Pessoa;

/**
 *
 * @author dfranco
 */
public interface PessoaService {

    /**
     *
     * @param pessoa
     */
    public void savePessoa(Pessoa pessoa);
}