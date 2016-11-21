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

    /**
     *
     * @param id
     * @param team
     * @param questoes
     */
    public Questionario(Integer id, Team team, List<Questao> questoes) {
        this.id = id;
        this.team = team;
        this.questoes = questoes;
    }

    /**
     *
     */
    public Questionario() {
    }

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Team getTeam() {
        return team;
    }

    /**
     *
     * @param team
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     *
     * @return
     */
    public List<Questao> getQuestoes() {
        return questoes;
    }

    /**
     *
     * @param questoes
     */
    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 97 * hash + (this.team != null ? this.team.hashCode() : 0);
        hash = 97 * hash + (this.questoes != null ? this.questoes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Questionario other = (Questionario) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.team != other.team && (this.team == null || !this.team.equals(other.team))) {
            return false;
        }
        if (this.questoes != other.questoes && (this.questoes == null || !this.questoes.equals(other.questoes))) {
            return false;
        }
        return true;
    }
    
    

}
