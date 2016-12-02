/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.model;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author dfranco
 */
@Entity
@Table
@SuppressWarnings("PersistenceUnitPresent")
public class Professor extends Pessoa {

    @Column(unique = true)
    private String matricula;

    @Column(unique = true)
    private String email;

    @OneToMany
    @ElementCollection
    private List<Turma> turmasCadastradas;

    @ManyToMany(mappedBy = "alunos")
    private List<Equipe> equipes;

    /**
     *
     */
    public Professor() {

    }

    /**
     *
     * @param matricula
     * @param email
     * @param turmasCadastradas
     */
    public Professor(String matricula, String email, List<Turma> turmasCadastradas) {
        this.matricula = matricula;
        this.email = email;
        this.turmasCadastradas = turmasCadastradas;
    }

    /**
     *
     * @return
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     *
     * @param matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public List<Turma> getTurmasCadastradas() {
        return turmasCadastradas;
    }

    /**
     *
     * @param turmasCadastradas
     */
    public void setTurmasCadastradas(List<Turma> turmasCadastradas) {
        this.turmasCadastradas = turmasCadastradas;
    }

    public List<Equipe> getTeams() {
        return equipes;
    }

    public void setTeams(List<Equipe> teams) {
        this.equipes = teams;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (this.matricula != null ? this.matricula.hashCode() : 0);
        hash = 71 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 71 * hash + (this.turmasCadastradas != null ? this.turmasCadastradas.hashCode() : 0);
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
        final Professor other = (Professor) obj;
        if ((this.matricula == null) ? (other.matricula != null) : !this.matricula.equals(other.matricula)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if (this.turmasCadastradas != other.turmasCadastradas && (this.turmasCadastradas == null || !this.turmasCadastradas.equals(other.turmasCadastradas))) {
            return false;
        }
        return true;
    }

}
