/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.service;

import br.ufg.jatai.fsw.sisquest.model.Pessoa;
import br.ufg.jatai.fsw.sisquest.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public void savePessoa(Pessoa pessoa) {
        pessoaRepository.findAll();
        pessoaRepository.save(pessoa);
    }

}