/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.model;

import java.util.List;

/**
 *
 * @author dfranco
 */
public class Questionario {

    private Integer id;
    private Team team;
    private List<Questao> questoes;

    public Questionario(Integer id, Team team, List<Questao> questoes) {
        this.id = id;
        this.team = team;
        this.questoes = questoes;
    }

    public Questionario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }
    
    

}
