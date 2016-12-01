/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.service;

import br.ufg.jatai.fsw.sisquest.model.Aluno;
import br.ufg.jatai.fsw.sisquest.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Aluno inserir(Aluno entidade) {
        return alunoRepository.save(entidade);
    }

    @Override
    public void apagar(Aluno entidade) {
        alunoRepository.delete(entidade);
    }

    @Override
    public Aluno atualizar(Aluno entidade) {
        return alunoRepository.save(entidade);
    }

    @Override
    public Aluno find(Aluno entidade) {
        return find(entidade.getId());
    }

    @Override
    public Aluno find(Integer id) {
        return alunoRepository.findOne(id);
    }

    @Override
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }
    
}
