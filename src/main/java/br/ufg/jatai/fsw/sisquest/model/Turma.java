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
public class Turma {

    private Integer id;
    private String nome;
    private String descricao;
    private List<Tarefa> tarefas;
    private List<Team> teams;

    public Turma() {
    }

    public Turma(Integer id, String nome, String descricao, List<Tarefa> tarefas, List<Team> teams) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tarefas = tarefas;
        this.teams = teams;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 17 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 17 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        hash = 17 * hash + (this.tarefas != null ? this.tarefas.hashCode() : 0);
        hash = 17 * hash + (this.teams != null ? this.teams.hashCode() : 0);
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
        final Turma other = (Turma) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.tarefas != other.tarefas && (this.tarefas == null || !this.tarefas.equals(other.tarefas))) {
            return false;
        }
        if (this.teams != other.teams && (this.teams == null || !this.teams.equals(other.teams))) {
            return false;
        }
        return true;
    }
    
    
}
