/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.service;

import br.ufg.jatai.fsw.sisquest.model.Pessoa;
import br.ufg.jatai.fsw.sisquest.repository.PessoaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Pessoa inserir(Pessoa entidade) {
        return pessoaRepository.save(entidade);
    }

    @Override
    public void apagar(Pessoa entidade) {
        pessoaRepository.delete(entidade);
    }

    @Override
    public Pessoa atualizar(Pessoa entidade) {
        return pessoaRepository.save(entidade);
    }

    @Override
    public Pessoa find(Pessoa entidade) {
        return pessoaRepository.findOne(entidade.getId());
    }

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

}
