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
    private List<Student> students;
    private String password;
    private Classes classes;

    /**
     *
     */
    public Team() {
    }

    /**
     *
     * @param id
     * @param name
     * @param students
     * @param password
     * @param classes
     */
    public Team(Integer id, String name, List<Student> students, String password, Classes classes) {
        this.id = id;
        this.name = name;
        this.students = students;
        this.password = password;
        this.classes = classes;
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
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     *
     * @param students
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public Classes getClasses() {
        return classes;
    }

    /**
     *
     * @param classes
     */
    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 41 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 41 * hash + (this.students != null ? this.students.hashCode() : 0);
        hash = 41 * hash + (this.password != null ? this.password.hashCode() : 0);
        hash = 41 * hash + (this.classes != null ? this.classes.hashCode() : 0);
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
        final Team other = (Team) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            return false;
        }
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.students != other.students && (this.students == null || !this.students.equals(other.students))) {
            return false;
        }
        if (this.classes != other.classes && (this.classes == null || !this.classes.equals(other.classes))) {
            return false;
        }
        return true;
    }
    
}
