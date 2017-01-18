/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.service;

import br.ufg.jatai.fsw.squest.domain.Questao;
import br.ufg.jatai.fsw.squest.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author vilela
 */
@Service
public class QuestaoServiceImpl implements QuestaoService {

    @Autowired
    private QuestaoRepository questaoRepository;

    @Override
    public Questao inserir(Questao entidade) {
        return questaoRepository.save(entidade);
    }

    @Override
    public void apagar(Questao entidade) {
        questaoRepository.delete(entidade);
    }

    @Override
    public Questao atualizar(Questao entidade) {
        return questaoRepository.save(entidade);
    }

    @Override
    public Questao find(Questao entidade) {
        return find(entidade.getId());
    }

    @Override
    public Questao find(Integer id) {
        return questaoRepository.findOne(id);
    }

    @Override
    public List<Questao> findAll() {
        return questaoRepository.findAll();
    }

    @Override
    public Set<Questao> questoesDoQuestionario(Integer questionarioID) {
        return questaoRepository.questoesDoQuestionario(questionarioID);
    }

    @Override
    public void ativarQuestao(Integer idQuestao) {

        Questao questao = questaoRepository.findOne(idQuestao);
        boolean ativa = questao.isAtiva();
        questao.setAtiva(!ativa);
        atualizar(questao);


    }
}
