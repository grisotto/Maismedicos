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
public class Team {
    private Integer id;
    private String name;
    private List<Aluno> students;
    private String password;
    private Turma turma;

    public Team() {
    }

    public Team(Integer id, String name, List<Aluno> students, String password, Turma turma) {
        this.id = id;
        this.name = name;
        this.students = students;
        this.password = password;
        this.turma = turma;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Aluno> getStudents() {
        return students;
    }

    public void setStudents(List<Aluno> students) {
        this.students = students;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    
}
