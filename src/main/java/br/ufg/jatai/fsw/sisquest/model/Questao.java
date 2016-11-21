package br.ufg.jatai.fsw.sisquest.model;

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dfranco
 */
public class Questao {

    private Integer id;
    private String questao;
    private List<Alternativa> alternativas;

    public Questao(Integer id, String questao, List<Alternativa> alternativas) {
        this.id = id;
        this.questao = questao;
        this.alternativas = alternativas;
    }

    public Questao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestao() {
        return questao;
    }

    public void setQuestao(String questao) {
        this.questao = questao;
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }
    
    
    
}
