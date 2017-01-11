package br.ufg.jatai.fsw.squest.controller.modelForm;

import br.ufg.jatai.fsw.squest.domain.Alternativa;
import br.ufg.jatai.fsw.squest.domain.Questao;
import br.ufg.jatai.fsw.squest.domain.Questionario;

/**
 * @author dyeimys
 *         Created by dyeimys on 09/01/17.
 *         <p>
 *         Classe para modelo para inserçaõ de questão
 */
public class QuestãoModel {
    private Questionario questionario;
    private String descricao;
    private Alternativa alternativaA;
    private Alternativa alternativaB;
    private Alternativa alternativaC;
    private Alternativa alternativaD;
    private Alternativa alternativaE;


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    public Alternativa getAlternativaA() {
        return alternativaA;
    }

    public void setAlternativaA(Alternativa alternativaA) {
        this.alternativaA = alternativaA;
    }

    public Alternativa getAlternativaB() {
        return alternativaB;
    }

    public void setAlternativaB(Alternativa alternativaB) {
        this.alternativaB = alternativaB;
    }

    public Alternativa getAlternativaC() {
        return alternativaC;
    }

    public void setAlternativaC(Alternativa alternativaC) {
        this.alternativaC = alternativaC;
    }

    public Alternativa getAlternativaD() {
        return alternativaD;
    }

    public void setAlternativaD(Alternativa alternativaD) {
        this.alternativaD = alternativaD;
    }

    public Alternativa getAlternativaE() {
        return alternativaE;
    }

    public void setAlternativaE(Alternativa alternativaE) {
        this.alternativaE = alternativaE;
    }

    public Questao getQuestao() {
        Questao questao = new Questao();
        questao.setQuestion(descricao);
        
        alternativaA.setQuestao(questao);
        alternativaB.setQuestao(questao);
        alternativaC.setQuestao(questao);
        alternativaD.setQuestao(questao);
        alternativaE.setQuestao(questao);
        
        questao.getAlternativas().add(alternativaA);
        questao.getAlternativas().add(alternativaB);
        questao.getAlternativas().add(alternativaC);
        questao.getAlternativas().add(alternativaD);
        questao.getAlternativas().add(alternativaE);

        return questao;
    }
}
