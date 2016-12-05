/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author dfranco
 */
@Entity
@Table
@SuppressWarnings("PersistenceUnitPresent")
public class Aluno extends Pessoa {

    @Column(unique = true)
    private String matricula;

    @Column(unique = true)
    private String email;

    
    

    @ManyToMany(mappedBy = "alunos")
    private List<Equipe> equipes;
    @ManyToMany(mappedBy = "alunos")
    private List<Turma> turmas;

    /**
     *
     */
    public Aluno() {

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

   

    public List<Equipe> getTeams() {
        return equipes;
    }

    public void setTeams(List<Equipe> teams) {
        this.equipes = teams;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.matricula);
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.equipes);
        hash = 29 * hash + Objects.hashCode(this.turmas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.equipes, other.equipes)) {
            return false;
        }
        if (!Objects.equals(this.turmas, other.turmas)) {
            return false;
        }
        return true;
    }

   
}
