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

public class Student extends Person {

    @Id
    private String enrollment;

    private String email;
    private List<Classes> registeredClasses;

    /**
     *
     */
    public Student() {
       
    }

    /**
     *
     * @param enrollment
     * @param email
     * @param registeredClasses
     */
    public Student(String enrollment, String email, List<Classes> registeredClasses) {
        this.enrollment = enrollment;
        this.email = email;
        this.registeredClasses = registeredClasses;
    }

    /**
     *
     * @return
     */
    public String getEnrollment() {
        return enrollment;
    }

    /**
     *
     * @param enrollment
     */
    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
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
    public List<Classes> getRegisteredClasses() {
        return registeredClasses;
    }

    /**
     *
     * @param registeredClasses
     */
    public void setRegisteredClasses(List<Classes> registeredClasses) {
        this.registeredClasses = registeredClasses;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (this.enrollment != null ? this.enrollment.hashCode() : 0);
        hash = 71 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 71 * hash + (this.registeredClasses != null ? this.registeredClasses.hashCode() : 0);
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
        final Student other = (Student) obj;
        if ((this.enrollment == null) ? (other.enrollment != null) : !this.enrollment.equals(other.enrollment)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if (this.registeredClasses != other.registeredClasses && (this.registeredClasses == null || !this.registeredClasses.equals(other.registeredClasses))) {
            return false;
        }
        return true;
    }

}
