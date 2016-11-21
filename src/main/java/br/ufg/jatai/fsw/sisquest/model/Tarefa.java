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
    

}
