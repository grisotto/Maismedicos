package br.ufg.jatai.fsw.squest.domain.quis;

import br.ufg.jatai.fsw.squest.domain.Alternativa;
import br.ufg.jatai.fsw.squest.domain.Equipe;
import br.ufg.jatai.fsw.squest.domain.Questao;

import javax.persistence.*;

/**
 * Created by dyeimys on 21/01/17.
 */
@Entity
public class RespotaQuestaoQuiz {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Alternativa alternativa;

    @ManyToOne(cascade = CascadeType.ALL)
    private Equipe equipe;

    @ManyToOne(cascade = CascadeType.ALL)
    private Questao questao;

    public Alternativa getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(Alternativa alternativa) {
        this.alternativa = alternativa;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }
}
