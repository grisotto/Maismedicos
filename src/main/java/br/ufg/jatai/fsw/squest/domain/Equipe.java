/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.domain;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @NotNull
    @NotBlank
    private String nome;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Aluno> alunos = new ArrayList<>();

    private boolean ativa;

    @ManyToOne
    private Tarefa tarefa;


    @OneToOne(cascade = CascadeType.PERSIST)
    private Usuario usuario;

    /**
     *
     */
    public Equipe() {
    }

    /**
     *
     * @param nome
     * @param alunos
     */
    public Equipe(String nome, List<Aluno> alunos, boolean ativa, Tarefa tarefa, Usuario usuario) {
        this.nome = nome;
        this.alunos = alunos;
        this.ativa = ativa;
        this.tarefa = tarefa;
        this.usuario = usuario;
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
    public Tarefa getTarefa() {
        return tarefa;
    }

    /**
     *
     * @param tarefa
     */
    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    /**
     *
     * @return
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     *
     * @param usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     *
     * @return
     */
    public boolean isAtiva() {
        return ativa;
    }

    /**
     *
     * @param ativa
     */
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
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
        if (this.ativa != other.ativa) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.alunos, other.alunos)) {
            return false;
        }
        if (!Objects.equals(this.tarefa, other.tarefa)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.alunos);
        hash = 59 * hash + (this.ativa ? 1 : 0);
        hash = 59 * hash + Objects.hashCode(this.tarefa);
        hash = 59 * hash + Objects.hashCode(this.usuario);
        return hash;
    }

 
   

    @Override
    public String toString() {
        return "Equipe{" + "id=" + id + ", nome=" + nome + ", ativa=" + ativa + '}';
    }

    /**
     *
     * @param aluno
     * @return
     */
    public boolean add(Aluno aluno) {
        return alunos.add(aluno);
    }
}

