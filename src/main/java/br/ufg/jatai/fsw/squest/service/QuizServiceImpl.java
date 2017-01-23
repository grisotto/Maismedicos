package br.ufg.jatai.fsw.squest.service;

import br.ufg.jatai.fsw.squest.domain.quis.Quiz;
import br.ufg.jatai.fsw.squest.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dyeimys on 22/01/17.
 */
@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepository quizRepository;

    /**
     * @param entidade
     * @return
     */
    @Override
    public Quiz inserir(Quiz entidade) {
        return quizRepository.save(entidade);
    }

    /**
     * @param entidade
     */
    @Override
    public void apagar(Quiz entidade) {

    }

    /**
     * @param entidade
     * @return
     */
    @Override
    public Quiz atualizar(Quiz entidade) {
        return quizRepository.save(entidade);
    }

    /**
     * @param entidade
     * @return
     */
    @Override
    public Quiz find(Quiz entidade) {
        return this.find(entidade.getId());
    }

    /**
     * @param integer
     * @return
     */
    @Override
    public Quiz find(Integer integer) {
        return quizRepository.findOne(integer);
    }

    /**
     * @return
     */
    @Override
    public List<Quiz> findAll() {
        return quizRepository.findAll();
    }
}
