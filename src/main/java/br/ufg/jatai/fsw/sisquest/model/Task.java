/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.model;

import br.ufg.jatai.fsw.sisquest.model.etapas.EtapaEvento;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author dfranco
 */

@Entity
@Table
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;
    private Classes classes;
    private EtapaEvento etapaAtual;
    private List<EtapaEvento> etapaEventos;
    private Integer questionsSize;
    private List<Quiz> quizzes;

    /**
     *
     */
    public Task() {
    }

    /**
     *
     * @param id
     * @param description
     * @param classes
     * @param etapaAtual
     * @param etapaEventos
     * @param questionsSize
     * @param quizzes
     */
    public Task(Integer id, String description, Classes classes, EtapaEvento etapaAtual, List<EtapaEvento> etapaEventos, Integer questionsSize, List<Quiz> quizzes) {
        this.id = id;
        this.description = description;
        this.classes = classes;
        this.etapaAtual = etapaAtual;
        this.etapaEventos = etapaEventos;
        this.questionsSize = questionsSize;
        this.quizzes = quizzes;
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

    /**
     *
     * @return
     */
    public EtapaEvento getEtapaAtual() {
        return etapaAtual;
    }

    /**
     *
     * @param etapaAtual
     */
    public void setEtapaAtual(EtapaEvento etapaAtual) {
        this.etapaAtual = etapaAtual;
    }

    /**
     *
     * @return
     */
    public List<EtapaEvento> getEtapaEventos() {
        return etapaEventos;
    }

    /**
     *
     * @param etapaEventos
     */
    public void setEtapaEventos(List<EtapaEvento> etapaEventos) {
        this.etapaEventos = etapaEventos;
    }

    /**
     *
     * @return
     */
    public Integer getQuestionsSize() {
        return questionsSize;
    }

    /**
     *
     * @param questionsSize
     */
    public void setQuestionsSize(Integer questionsSize) {
        this.questionsSize = questionsSize;
    }

    /**
     *
     * @return
     */
    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    /**
     *
     * @param quizzes
     */
    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 79 * hash + (this.description != null ? this.description.hashCode() : 0);
        hash = 79 * hash + (this.classes != null ? this.classes.hashCode() : 0);
        hash = 79 * hash + (this.etapaAtual != null ? this.etapaAtual.hashCode() : 0);
        hash = 79 * hash + (this.etapaEventos != null ? this.etapaEventos.hashCode() : 0);
        hash = 79 * hash + (this.questionsSize != null ? this.questionsSize.hashCode() : 0);
        hash = 79 * hash + (this.quizzes != null ? this.quizzes.hashCode() : 0);
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
        final Task other = (Task) obj;
        if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
            return false;
        }
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.classes != other.classes && (this.classes == null || !this.classes.equals(other.classes))) {
            return false;
        }
        if (this.etapaAtual != other.etapaAtual && (this.etapaAtual == null || !this.etapaAtual.equals(other.etapaAtual))) {
            return false;
        }
        if (this.etapaEventos != other.etapaEventos && (this.etapaEventos == null || !this.etapaEventos.equals(other.etapaEventos))) {
            return false;
        }
        if (this.questionsSize != other.questionsSize && (this.questionsSize == null || !this.questionsSize.equals(other.questionsSize))) {
            return false;
        }
        if (this.quizzes != other.quizzes && (this.quizzes == null || !this.quizzes.equals(other.quizzes))) {
            return false;
        }
        return true;
    }
    

}
