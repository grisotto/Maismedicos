/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.service;

import br.ufg.jatai.fsw.sisquest.model.Tarefa;
import br.ufg.jatai.fsw.sisquest.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class TarefaServiceImpl implements TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Override
    public Tarefa inserir(Tarefa entidade) {
        return tarefaRepository.save(entidade);
    }

    @Override
    public void apagar(Tarefa entidade) {
        tarefaRepository.delete(entidade);
    }

    @Override
    public Tarefa atualizar(Tarefa entidade) {
        return tarefaRepository.save(entidade);
    }

    @Override
    public Tarefa find(Tarefa entidade) {
        return find(entidade.getId());
    }

    @Override
    public Tarefa find(Integer id) {
        return tarefaRepository.findOne(id);
    }

    @Override
    public List<Tarefa> findAll() {
        return tarefaRepository.findAll();
    }
    
}
