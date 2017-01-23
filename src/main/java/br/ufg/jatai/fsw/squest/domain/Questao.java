package br.ufg.jatai.fsw.squest.domain;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author dfranco
 */
@Entity
@Table
public class Questao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    private String question;

    @Enumerated(value = EnumType.STRING)
    private SituacaoQuestao situacaoQuestao;

    @OneToMany(mappedBy = "questao", cascade = CascadeType.ALL)
    private List<Alternativa> alternativas = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Questionario questionario;

    @Transient
    private boolean aprovada;

    @Transient
    private boolean reprovada;

    @Transient
    private boolean aguardando;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime updated;

    /**
     * @param id
     * @param question
     * @param alternativas
     */
    public Questao(Integer id, String question, List<Alternativa> alternativas, SituacaoQuestao sistuacaoQuestao) {
        this.id = id;
        this.question = question;
        this.alternativas = alternativas;
        this.situacaoQuestao = situacaoQuestao;
    }

    /**
     *
     */
    public Questao() {
    }

    @PreUpdate
    @PrePersist
    protected void onUpdate() {
        updated = DateTime.now();
    }

    /**
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return
     */
    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    /**
     * @param alternativas
     */
    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Questao)) return false;

        Questao questao = (Questao) o;

        if (getId() != null ? !getId().equals(questao.getId()) : questao.getId() != null) return false;
        if (getQuestion() != null ? !getQuestion().equals(questao.getQuestion()) : questao.getQuestion() != null)
            return false;
        if (situacaoQuestao != questao.situacaoQuestao) return false;
        if (getAlternativas() != null ? !getAlternativas().equals(questao.getAlternativas()) : questao.getAlternativas() != null)
            return false;
        return getQuestionario() != null ? getQuestionario().equals(questao.getQuestionario()) : questao.getQuestionario() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getQuestion() != null ? getQuestion().hashCode() : 0);
        result = 31 * result + (situacaoQuestao != null ? situacaoQuestao.hashCode() : 0);
        result = 31 * result + (getAlternativas() != null ? getAlternativas().hashCode() : 0);
        result = 31 * result + (getQuestionario() != null ? getQuestionario().hashCode() : 0);
        return result;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    @Override
    public String toString() {
        return "Questao{" + "id=" + id + ", question=" + question + ", alternativas=" + alternativas + ", sistuacaoQuestao=" + situacaoQuestao + '}';
    }

    public SituacaoQuestao getSituacaoQuestao() {
        return situacaoQuestao;
    }

    public void setSituacaoQuestao(SituacaoQuestao situacaoQuestao) {
        this.situacaoQuestao = situacaoQuestao;
    }

    public boolean isAprovada() {
        return situacaoQuestao.equals(SituacaoQuestao.APROVADO);
    }

    public boolean isReprovado() {
        return situacaoQuestao.equals(SituacaoQuestao.REPROVADO);
    }

    public boolean isAguardando() {
        return situacaoQuestao.equals(SituacaoQuestao.AGUARDANDO);
    }

    public DateTime getUpdated() {
        return updated;
    }

    public enum SituacaoQuestao {
        AGUARDANDO, APROVADO, REPROVADO;
    }
}
