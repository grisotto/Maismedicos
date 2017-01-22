package br.ufg.jatai.fsw.squest.domain.quis;

import br.ufg.jatai.fsw.squest.domain.Alternativa;
import br.ufg.jatai.fsw.squest.domain.Equipe;
import br.ufg.jatai.fsw.squest.domain.Tarefa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by dyeimys on 21/01/17.
 */
@Entity
public class Quiz {
    //Numero total de Questões (TODAS EQUIPES)
    // > Referencia de Numero de Quetões da Tarefa (QNT MAX)
    // > Referencia de Questões por equipe (APROVADAS)
    //Referencia de respostas por equipe

    //Com numero de questços da tarefa e questoes aprovadas temos indice baseado em C1

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<QuestaoQuiz> questaoQuizes;

    @OneToOne
    private Tarefa tarefa;

    public Quiz() {
        this.questaoQuizes = new HashSet<>();
    }

    public Set<QuestaoQuiz> getQuestaoQuizes() {
        return questaoQuizes;
    }

    public void setQuestaoQuizes(Set<QuestaoQuiz> questaoQuizes) {
        this.questaoQuizes = questaoQuizes;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public Set<QuestaoQuiz> questaoToEquipe(Equipe equipe) {
        Set<QuestaoQuiz> retorno = new HashSet<>();
        for (QuestaoQuiz questaoQuize : questaoQuizes) {
            if (!questaoQuize.getQuestao().getQuestionario().getTime().equals(equipe)) {
                retorno.add(questaoQuize);
            }
        }

        return retorno;
    }

    /**
     * Quantidade maxima de questões por equipe
     *
     * @return
     */
    public Integer getTamanhoQuestoes() {
        return tarefa.getTamanhoQuestoes();
    }

    public Integer getSizeQuestaosEquipe(Equipe e) {
        return questaoToEquipe(e).size();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quiz)) return false;

        Quiz quiz = (Quiz) o;

        if (getId() != null ? !getId().equals(quiz.getId()) : quiz.getId() != null) return false;
        if (getQuestaoQuizes() != null ? !getQuestaoQuizes().equals(quiz.getQuestaoQuizes()) : quiz.getQuestaoQuizes() != null)
            return false;
        return getTarefa() != null ? getTarefa().equals(quiz.getTarefa()) : quiz.getTarefa() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getQuestaoQuizes() != null ? getQuestaoQuizes().hashCode() : 0);
        result = 31 * result + (getTarefa() != null ? getTarefa().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", questaoQuizes=" + questaoQuizes +
                ", tarefa=" + tarefa +
                '}';
    }
}
