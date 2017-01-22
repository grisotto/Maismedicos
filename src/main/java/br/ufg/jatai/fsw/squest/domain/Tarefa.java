/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.domain;

import java.io.Serializable;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

import br.ufg.jatai.fsw.squest.domain.quis.Quiz;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author dfranco
 */
@Entity
@Table
@SuppressWarnings("PersistenceUnitPresent")
public class Tarefa implements Serializable {

    private static final long serialVersionUID = -8612342342378087155L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String descricao;

    @ManyToOne
    private Turma turma;

    @ManyToOne(fetch = FetchType.EAGER)
    private EtapaEvento etapaAtual;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<EtapaEvento> etapaEventos;

    private Integer tamanhoQuestoes;

    @OneToMany(mappedBy = "tarefa",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Questionario> questionarios;
    @OneToMany(mappedBy = "tarefa")
    private List<Equipe> equipes;


    @OneToOne(mappedBy = "tarefa", fetch = FetchType.EAGER)
    private Quiz quiz;
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
    public Tarefa(Integer id, String descricao, Turma turma, EtapaEvento etapaAtual, Set<EtapaEvento> etapaEventos, Integer tamanhoQuestoes, Set<Questionario> questionarios) {
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
    public Set<EtapaEvento> getEtapaEventos() {
        return etapaEventos;
    }

    /**
     *
     * @param etapaEventos
     */
    public void setEtapaEventos(Set<EtapaEvento> etapaEventos) {
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
    public Set<Questionario> getQuestionarios() {
        return questionarios;
    }

    /**
     *
     * @param questionarios
     */
    public void setQuestionarios(Set<Questionario> questionarios) {
        this.questionarios = questionarios;
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 79 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
//        hash = 79 * hash + (this.turma != null ? this.turma.hashCode() : 0);
        hash = 79 * hash + (this.etapaAtual != null ? this.etapaAtual.hashCode() : 0);
        hash = 79 * hash + (this.etapaEventos != null ? this.etapaEventos.hashCode() : 0);
        hash = 79 * hash + (this.tamanhoQuestoes != null ? this.tamanhoQuestoes.hashCode() : 0);
//        hash = 79 * hash + (this.questionarios != null ? this.questionarios.hashCode() : 0);
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

    /**
     *
     * @return
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     *
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     *
     * @return
     */
    public List<Equipe> getEquipes() {
        return equipes;
    }

    /**
     *
     * @param equipes
     */
    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", turma=" + turma +
                ", tamanhoQuestoes=" + tamanhoQuestoes +
                '}';
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
