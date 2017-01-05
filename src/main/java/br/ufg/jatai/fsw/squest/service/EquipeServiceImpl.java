/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.service;

import br.ufg.jatai.fsw.squest.domain.Equipe;
import br.ufg.jatai.fsw.squest.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author vilela
 */
@Service
public class EquipeServiceImpl implements EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;

    @Override
    public Equipe inserir(Equipe entidade) {
        return equipeRepository.save(entidade);
    }

    @Override
    public void apagar(Equipe entidade) {
        equipeRepository.delete(entidade);
    }

    @Override
    public Equipe atualizar(Equipe entidade) {
        return equipeRepository.save(entidade);
    }

    @Override
    public Equipe find(Equipe entidade) {
        return find(entidade.getId());
    }

    @Override
    public Equipe find(Integer id) {
        return equipeRepository.findOne(id);
    }

    @Override
    public List<Equipe> findAll() {
        return equipeRepository.findAll();
    }
    
}
