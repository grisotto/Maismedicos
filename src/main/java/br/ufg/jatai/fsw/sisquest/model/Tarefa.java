/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.model;

import br.ufg.jatai.fsw.sisquest.model.etapas.EtapaEvento;
import java.util.List;

/**
 *
 * @author dfranco
 */
public class Tarefa {

    private Integer id;
    private String descricao;
    private Turma turma;
    private EtapaEvento etapaAtual;
    private List<EtapaEvento> etapaEventos;
    private Integer questionsSize;
    private List<Questionario> questionarios;

    public Tarefa() {
    }

    public Tarefa(Integer id, String descricao, Turma turma, EtapaEvento etapaAtual, List<EtapaEvento> etapaEventos, Integer questionsSize, List<Questionario> questionarios) {
        this.id = id;
        this.descricao = descricao;
        this.turma = turma;
        this.etapaAtual = etapaAtual;
        this.etapaEventos = etapaEventos;
        this.questionsSize = questionsSize;
        this.questionarios = questionarios;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public EtapaEvento getEtapaAtual() {
        return etapaAtual;
    }

    public void setEtapaAtual(EtapaEvento etapaAtual) {
        this.etapaAtual = etapaAtual;
    }

    public List<EtapaEvento> getEtapaEventos() {
        return etapaEventos;
    }

    public void setEtapaEventos(List<EtapaEvento> etapaEventos) {
        this.etapaEventos = etapaEventos;
    }

    public Integer getQuestionsSize() {
        return questionsSize;
    }

    public void setQuestionsSize(Integer questionsSize) {
        this.questionsSize = questionsSize;
    }

    public List<Questionario> getQuestionarios() {
        return questionarios;
    }

    public void setQuestionarios(List<Questionario> questionarios) {
        this.questionarios = questionarios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 79 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        hash = 79 * hash + (this.turma != null ? this.turma.hashCode() : 0);
        hash = 79 * hash + (this.etapaAtual != null ? this.etapaAtual.hashCode() : 0);
        hash = 79 * hash + (this.etapaEventos != null ? this.etapaEventos.hashCode() : 0);
        hash = 79 * hash + (this.questionsSize != null ? this.questionsSize.hashCode() : 0);
        hash = 79 * hash + (this.questionarios != null ? this.questionarios.hashCode() : 0);
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
        final Tarefa other = (Tarefa) obj;
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.turma != other.turma && (this.turma == null || !this.turma.equals(other.turma))) {
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
        if (this.questionarios != other.questionarios && (this.questionarios == null || !this.questionarios.equals(other.questionarios))) {
            return false;
        }
        return true;
    }
    

}
