/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.service;

import br.ufg.jatai.fsw.sisquest.model.Questionario;
import br.ufg.jatai.fsw.sisquest.repository.QuestionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 * @author vilela
 */
public class QuestionarioServiceImpl implements QuestionarioService {

    @Autowired
    private QuestionarioRepository questionarioRepository;

    @Override
    public Questionario inserir(Questionario entidade) {
        return questionarioRepository.save(entidade);
    }

    @Override
    public void apagar(Questionario entidade) {
        questionarioRepository.delete(entidade);
    }

    @Override
    public Questionario atualizar(Questionario entidade) {
        return questionarioRepository.save(entidade);
    }

    @Override
    public Questionario find(Questionario entidade) {
        return find(entidade.getId());
    }

    @Override
    public Questionario find(Integer id) {
        return questionarioRepository.findOne(id);
    }

    @Override
    public List<Questionario> findAll() {
        return questionarioRepository.findAll();
    }
    
}
