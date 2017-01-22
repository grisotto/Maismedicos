package br.ufg.jatai.fsw.squest.domain.quis;

import br.ufg.jatai.fsw.squest.domain.Equipe;
import br.ufg.jatai.fsw.squest.domain.Questao;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dyeimys on 21/01/17.
 */
@Entity
public class QuestaoQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Questao questao;


    @ManyToOne
    private Equipe questaoDe;


    @OneToMany(cascade = CascadeType.PERSIST)
    private List<RespotaQuestaoQuiz> respotaQuestaoQuizs;

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public List<RespotaQuestaoQuiz> getRespotaQuestaoQuizs() {
        return respotaQuestaoQuizs;
    }

    public void setRespotaQuestaoQuizs(List<RespotaQuestaoQuiz> respotaQuestaoQuizs) {
        this.respotaQuestaoQuizs = respotaQuestaoQuizs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Equipe getQuestaoDe() {
        return questaoDe;
    }

    public void setQuestaoDe(Equipe questaoDe) {
        this.questaoDe = questaoDe;
    }
}
