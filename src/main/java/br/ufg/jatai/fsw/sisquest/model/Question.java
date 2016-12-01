package br.ufg.jatai.fsw.sisquest.model;

import javax.persistence.*;
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

@Entity
@Table
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String question;
    private List<Alternative> alternatives;

    /**
     *
     * @param id
     * @param question
     * @param alternatives
     */
    public Question(Integer id, String question, List<Alternative> alternatives) {
        this.id = id;
        this.question = question;
        this.alternatives = alternatives;
    }

    /**
     *
     */
    public Question() {
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
    public String getQuestion() {
        return question;
    }

    /**
     *
     * @param question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     *
     * @return
     */
    public List<Alternative> getAlternatives() {
        return alternatives;
    }

    /**
     *
     * @param alternatives
     */
    public void setAlternatives(List<Alternative> alternatives) {
        this.alternatives = alternatives;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 67 * hash + (this.question != null ? this.question.hashCode() : 0);
        hash = 67 * hash + (this.alternatives != null ? this.alternatives.hashCode() : 0);
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
        final Question other = (Question) obj;
        if ((this.question == null) ? (other.question != null) : !this.question.equals(other.question)) {
            return false;
        }
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.alternatives != other.alternatives && (this.alternatives == null || !this.alternatives.equals(other.alternatives))) {
            return false;
        }
        return true;
    }
    
    
    
}
