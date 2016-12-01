/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author dfranco
 */
@Entity
@Table
public class Alternativa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;
    private boolean correto;

    /**
     *
     */
    public Alternativa() {
        this(null, null, false);
    }

    /**
     *
     * @param id
     * @param descricao
     * @param correto
     */
    public Alternativa(Integer id, String descricao, boolean correto) {
        this.id = id;
        this.descricao = descricao;
        this.correto = correto;
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
    public String getDescricao() {
        return descricao;
    }

    /**
     *
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     *
     * @return
     */
    public boolean isCorreto() {
        return correto;
    }

    /**
     *
     * @param correto
     */
    public void setCorreto(boolean correto) {
        this.correto = correto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 37 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        hash = 37 * hash + (this.correto ? 1 : 0);
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
        final Alternativa other = (Alternativa) obj;
        if (this.correto != other.correto) {
            return false;
        }
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
