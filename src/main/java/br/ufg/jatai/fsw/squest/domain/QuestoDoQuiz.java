package br.ufg.jatai.fsw.squest.domain;

/**
 * Created by dyeimys on 21/01/17.
 */
public class QuestoDoQuiz {
    Questao questao;

    protected class RespostaQuiz {
        private QuestoDoQuiz questoDoQuiz;
        private Alternativa alternativa;
        private Equipe equipe;

        private boolean isCorrect(){
            return alternativa.isCorreto();
        }
    }
}
