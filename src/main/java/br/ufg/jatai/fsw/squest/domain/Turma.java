/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

/**
 *
 * @author dfranco
 */
@Entity
@Table
@SuppressWarnings("PersistenceUnitPresent")
public class Turma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String descricao;

//    @ElementCollection
    @OneToMany(mappedBy = "turma",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Tarefa> tarefas;

//    @ElementCollection
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Equipe> times;

    @ManyToOne
    private Professor professor;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Aluno> alunos;

    /**
     *
     */
    public Turma() {
    }

    /**
     *
     * @param id
     * @param nome
     * @param descricao
     * @param tarefas
     * @param times
     */
    public Turma(Integer id, String nome, String descricao, Set<Tarefa> tarefas, Set<Equipe> times) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tarefas = tarefas;
        this.times = times;
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
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
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
    public Set<Tarefa> getTarefas() {
        return tarefas;
    }

    /**
     *
     * @param tarefas
     */
    public void setTarefas(Set<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    /**
     *
     * @return
     */
    public Set<Equipe> getTimes() {
        return times;
    }

    /**
     *
     * @param times
     */
    public void setTimes(Set<Equipe> times) {
        this.times = times;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 17 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 17 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
//        hash = 17 * hash + (this.tarefas != null ? this.tarefas.hashCode() : 0);
        hash = 17 * hash + (this.times != null ? this.times.hashCode() : 0);
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
        if (this.times != other.times && (this.times == null || !this.times.equals(other.times))) {
            return false;
        }
        return true;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

}
