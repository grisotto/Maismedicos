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
public class Aluno extends Pessoa {

    private String matricula;
    private String email;
    private List<Turma> turmasCadastradas;

    public Aluno() {
       
    }

    public Aluno(String matricula, String email, List<Turma> turmasCadastradas) {
        this.matricula = matricula;
        this.email = email;
        this.turmasCadastradas = turmasCadastradas;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Turma> getTurmasCadastradas() {
        return turmasCadastradas;
    }

    public void setTurmasCadastradas(List<Turma> turmasCadastradas) {
        this.turmasCadastradas = turmasCadastradas;
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
        final Aluno other = (Aluno) obj;
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
