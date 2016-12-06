/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.service;

import br.ufg.jatai.fsw.sisquest.model.Turma;
import br.ufg.jatai.fsw.sisquest.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class TurmaServiceImpl implements TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Override
    public Turma inserir(Turma entidade) {
        return turmaRepository.save(entidade);
    }

    @Override
    public void apagar(Turma entidade) {
        turmaRepository.delete(entidade);
    }

    @Override
    public Turma atualizar(Turma entidade) {
        return turmaRepository.save(entidade);
    }

    @Override
    public Turma find(Turma entidade) {
        return find(entidade.getId());
    }

    @Override
    public Turma find(Integer id) {
        return turmaRepository.findOne(id);
    }

    @Override
    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }

}
