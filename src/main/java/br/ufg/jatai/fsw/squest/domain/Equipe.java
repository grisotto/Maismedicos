/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.domain;

import com.sun.mail.imap.protocol.ID;
import java.io.Serializable;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author dfranco
 */
@Entity
@Table
@SuppressWarnings("PersistenceUnitPresent")
public class Equipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToMany
    private List<Aluno> alunos;

    private String senha;

    @ManyToOne
    private Tarefa tarefa;


    @OneToOne
    private Usuario usuario;

    /**
     *
     */
    public Equipe() {
    }

    /**
     *
     * @param id
     * @param nome
     * @param alunos
     * @param senha
     */
    public Equipe(Integer id, String nome, List<Aluno> alunos, String senha, Tarefa tarefa) {
        this.id = id;
        this.nome = nome;
        this.alunos = alunos;
        this.senha = senha;
        this.tarefa = tarefa;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 41 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 41 * hash + (this.alunos != null ? this.alunos.hashCode() : 0);
        hash = 41 * hash + (this.senha != null ? this.senha.hashCode() : 0);
        hash = 41 * hash + (this.tarefa != null ? this.tarefa.hashCode() : 0);
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
        final Equipe other = (Equipe) obj;
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
        if (this.tarefa != other.tarefa && (this.tarefa == null || !this.tarefa.equals(other.tarefa))) {
            return false;
        }
        return true;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

}
