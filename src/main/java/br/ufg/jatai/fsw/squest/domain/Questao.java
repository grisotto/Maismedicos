package br.ufg.jatai.fsw.squest.domain;

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
public class Questao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String question;

    @OneToMany(mappedBy = "questao")
    private List<Alternativa> alternativas;
    @ManyToOne
    private Questionario questionario;
   

    /**
     *
     * @param id
     * @param question
     * @param alternativas
     */
    public Questao(Integer id, String question, List<Alternativa> alternativas) {
        this.id = id;
        this.question = question;
        this.alternativas = alternativas;
    }

    /**
     *
     */
    public Questao() {
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
    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    /**
     *
     * @param alternativas
     */
    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 67 * hash + (this.question != null ? this.question.hashCode() : 0);
        hash = 67 * hash + (this.alternativas != null ? this.alternativas.hashCode() : 0);
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
        final Questao other = (Questao) obj;
        if ((this.question == null) ? (other.question != null) : !this.question.equals(other.question)) {
            return false;
        }
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.alternativas != other.alternativas && (this.alternativas == null || !this.alternativas.equals(other.alternativas))) {
            return false;
        }
        return true;
    }

}
