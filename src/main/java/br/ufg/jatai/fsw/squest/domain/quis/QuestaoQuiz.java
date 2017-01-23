package br.ufg.jatai.fsw.squest.domain.quis;

import br.ufg.jatai.fsw.squest.domain.Equipe;
import br.ufg.jatai.fsw.squest.domain.Questao;
import java.io.Serializable;
import java.util.HashSet;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by dyeimys on 21/01/17.
 */
@Entity
public class QuestaoQuiz implements Serializable {

//    @ManyToOne(cascade = CascadeType.PERSIST)
//    private Quiz quiz;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Questao questao;

    @ManyToOne
    private Equipe equipe;


    @OneToMany
    private List<Equipe> equipeResponderam;
    
  

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

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe questaoDe) {
        this.equipe = questaoDe;
    }


    public boolean respondido(Equipe equipe){
        return equipeResponderam.contains(equipe);


    }

    public List<Equipe> getEquipeResponderam() {
        return equipeResponderam;
    }

    public void setEquipeResponderam(List<Equipe> equipeResponderam) {
        this.equipeResponderam = equipeResponderam;
    }

    public static class AjusteTecnico {

        /**
         *
         * @param questoes
         * @return
         */
        public static Set<QuestaoQuiz> create(Set<Questao> questoes) {
            Set<QuestaoQuiz> retorno = new HashSet<>();
            for (Questao q : questoes) {
                QuestaoQuiz qq = new QuestaoQuiz();
                qq.setQuestao(q);
                qq.setEquipe(q.getQuestionario().getTime());
                
                retorno.add(qq);
            }

            return retorno;
        }
    }
//
//    public Quiz getQuiz() {
//        return quiz;
//    }
//
//    public void setQuiz(Quiz quiz) {
//        this.quiz = quiz;
//    }
    
}
