package br.ufg.jatai.fsw.squest.service;

import br.ufg.jatai.fsw.squest.domain.quis.Quiz;

import java.util.List;

/**
 * Created by dyeimys on 22/01/17.
 */
public interface QuizService extends AbstractService<Quiz,Integer> {

    public List<Quiz> findAllByTarefa_Id(Integer id);
}
