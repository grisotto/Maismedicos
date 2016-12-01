/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.model;

import com.sun.mail.imap.protocol.ID;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author dfranco
 */


public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ElementCollection
    private List<Aluno> alunos;

    private String senha;

    @ManyToOne
    private Turma turma;

    /**
     *
     */
    public Time() {
    }

    /**
     *
     * @param id
     * @param nome
     * @param alunos
     * @param senha
     * @param turma
     */
    public Time(Integer id, String nome, List<Aluno> alunos, String senha, Turma turma) {
        this.id = id;
        this.nome = nome;
        this.alunos = alunos;
        this.senha = senha;
        this.turma = turma;
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
    public List<Aluno> getAlunos() {
        return alunos;
    }

    /**
     *
     * @param alunos
     */
    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    /**
     *
     * @return
     */
    public String getSenha() {
        return senha;
    }

    /**
     *
     * @param senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     *
     * @return
     */
    public Turma getTurma() {
        return turma;
    }

    /**
     *
     * @param turma
     */
    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 41 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 41 * hash + (this.alunos != null ? this.alunos.hashCode() : 0);
        hash = 41 * hash + (this.senha != null ? this.senha.hashCode() : 0);
        hash = 41 * hash + (this.turma != null ? this.turma.hashCode() : 0);
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
        final Time other = (Time) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.senha == null) ? (other.senha != null) : !this.senha.equals(other.senha)) {
            return false;
        }
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.alunos != other.alunos && (this.alunos == null || !this.alunos.equals(other.alunos))) {
            return false;
        }
        if (this.turma != other.turma && (this.turma == null || !this.turma.equals(other.turma))) {
            return false;
        }
        return true;
    }
    
}
