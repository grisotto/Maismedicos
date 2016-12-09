/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.model;

import br.ufg.jatai.fsw.sisquest.model.etapas.EtapaEvento;
import java.io.Serializable;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author dfranco
 */
@Entity
@Table
@SuppressWarnings("PersistenceUnitPresent")
public class Tarefa implements Serializable {

    private static final long serialVersionUID = -8614032819378087155L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String descricao;

    @ManyToOne
    private Turma turma;

    @ManyToOne
    private EtapaEvento etapaAtual;

    @OneToMany
    private List<EtapaEvento> etapaEventos;

    private Integer tamanhoQuestoes;

    @OneToMany(mappedBy = "tarefa")
    private List<Questionario> questionarios;
    @OneToOne(mappedBy = "tarefa")
    private Questionario questionario;

    /**
     *
     */
    public Tarefa() {
    }

    /**
     *
     * @param id
     * @param descricao
     * @param turma
     * @param etapaAtual
     * @param etapaEventos
     * @param tamanhoQuestoes
     * @param questionarios
     */
    public Tarefa(Integer id, String descricao, Turma turma, EtapaEvento etapaAtual, List<EtapaEvento> etapaEventos, Integer tamanhoQuestoes, List<Questionario> questionarios) {
        this.id = id;
        this.descricao = descricao;
        this.turma = turma;
        this.etapaAtual = etapaAtual;
        this.etapaEventos = etapaEventos;
        this.tamanhoQuestoes = tamanhoQuestoes;
        this.questionarios = questionarios;
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
    public String getDescricao() {
        return descricao;
    }

    /**
     *
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     *
     * @return
     */
    public Turma getTurma() {
        return turma;
    }

    /**
     *
     * @param turma
     */
    public void setTurma(Turma turma) {
        this.turma = turma;
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
    public Integer getTamanhoQuestoes() {
        return tamanhoQuestoes;
    }

    /**
     *
     * @param tamanhoQuestoes
     */
    public void setTamanhoQuestoes(Integer tamanhoQuestoes) {
        this.tamanhoQuestoes = tamanhoQuestoes;
    }

    /**
     *
     * @return
     */
    public List<Questionario> getQuestionarios() {
        return questionarios;
    }

    /**
     *
     * @param questionarios
     */
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
        hash = 79 * hash + (this.tamanhoQuestoes != null ? this.tamanhoQuestoes.hashCode() : 0);
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
        if (this.tamanhoQuestoes != other.tamanhoQuestoes && (this.tamanhoQuestoes == null || !this.tamanhoQuestoes.equals(other.tamanhoQuestoes))) {
            return false;
        }
        if (this.questionarios != other.questionarios && (this.questionarios == null || !this.questionarios.equals(other.questionarios))) {
            return false;
        }
        return true;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

}
