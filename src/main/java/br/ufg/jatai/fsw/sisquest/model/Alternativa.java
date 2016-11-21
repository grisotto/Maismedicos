/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.model;

/**
 *
 * @author dfranco
 */
public class Alternativa {

    private Integer id;
    private String descricao;
    private boolean correto;
    
    public Alternativa() {
        this(null, null, false);
    }
    
    public Alternativa(Integer id, String descricao, boolean correto) {
        this.id = id;
        this.descricao = descricao;
        this.correto = correto;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public boolean isCorreto() {
        return correto;
    }
    
    public void setCorreto(boolean correto) {
        this.correto = correto;
    }
    
}
