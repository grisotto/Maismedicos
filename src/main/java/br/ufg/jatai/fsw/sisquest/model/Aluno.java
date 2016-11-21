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

}
