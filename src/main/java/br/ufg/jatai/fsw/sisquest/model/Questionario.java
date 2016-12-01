/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.model;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author dfranco
 */

@Entity
@Table
public class Questionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Time time;
    private List<Questao> questoes;

    /**
     *
     * @param id
     * @param time
     * @param questoes
     */
    public Questionario(Integer id, Time time, List<Questao> questoes) {
        this.id = id;
        this.time = time;
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
    public Time gettime() {
        return time;
    }

    /**
     *
     * @param time
     */
    public void settime(Time time) {
        this.time = time;
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
    public void setquestions(List<Questao> questoes) {
        this.questoes = questoes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 97 * hash + (this.time != null ? this.time.hashCode() : 0);
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
        if (this.time != other.time && (this.time == null || !this.time.equals(other.time))) {
            return false;
        }
        if (this.questoes != other.questoes && (this.questoes == null || !this.questoes.equals(other.questoes))) {
            return false;
        }
        return true;
    }
    
    

}
