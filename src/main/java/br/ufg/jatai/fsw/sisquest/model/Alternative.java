/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.model;

import javax.persistence.*;

/**
 *
 * @author dfranco
 */

@Entity
@Table

public class Alternative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;
    private boolean right;
    
    /**
     *
     */
    public Alternative() {
        this(null, null, false);
    }
    
    /**
     *
     * @param id
     * @param description
     * @param right
     */

    public Alternative(Integer id, String description, boolean right) {
        this.id = id;
        this.description = description;
        this.right = right;
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
    public String getDescription() {
        return description;
    }
    
    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     *
     * @return
     */
    public boolean isRight() {
        return right;
    }
    
    /**
     *
     * @param right
     */
    public void setRight(boolean right) {
        this.right = right;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 37 * hash + (this.description != null ? this.description.hashCode() : 0);
        hash = 37 * hash + (this.right ? 1 : 0);
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
        final Alternative other = (Alternative) obj;
        if (this.right != other.right) {
            return false;
        }
        if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
            return false;
        }
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}
