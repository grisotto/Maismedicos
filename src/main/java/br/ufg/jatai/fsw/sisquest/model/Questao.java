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
public class Questao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String questao;
    private List<Alternativa> alternativas;

    /**
     *
     * @param id
     * @param questao
     * @param alternativas
     */
    public Questao(Integer id, String questao, List<Alternativa> alternativas) {
        this.id = id;
        this.questao = questao;
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
    public String getQuestao() {
        return questao;
    }

    /**
     *
     * @param questao
     */
    public void setQuestao(String questao) {
        this.questao = questao;
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
        hash = 67 * hash + (this.questao != null ? this.questao.hashCode() : 0);
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
        if ((this.questao == null) ? (other.questao != null) : !this.questao.equals(other.questao)) {
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
