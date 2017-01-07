/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.domain;

import com.sun.mail.imap.protocol.ID;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
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

    @NotNull
    @NotBlank
    private String nome;

    @ManyToMany
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




    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipe)) return false;

        Equipe equipe = (Equipe) o;

        if (isAtiva() != equipe.isAtiva()) return false;
        if (!getId().equals(equipe.getId())) return false;
        if (!getNome().equals(equipe.getNome())) return false;
        return getAlunos() != null ? getAlunos().equals(equipe.getAlunos()) : equipe.getAlunos() == null;
    }

    @Override
    public int hashCode() {
        int result = (getId() != null ? getId().hashCode(): 0);
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (isAtiva() ? 1 : 0);
        result = 31 * result + (getUsuario()!= null? getUsuario().hashCode():0);
        return result;
    }

    public boolean add(Aluno aluno) {
        return alunos.add(aluno);
    }
}

