package br.ufg.jatai.fsw.squest.service;

import br.ufg.jatai.fsw.squest.domain.Questao;
import br.ufg.jatai.fsw.squest.domain.quis.QuestaoQuiz;
import br.ufg.jatai.fsw.squest.repository.QuestaoQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestaoQuizServiceImpl implements QuestaoQuizService {

    @Autowired
    private QuestaoQuizRepository questaoQuizRepository;

    @Override
    public QuestaoQuiz inserir(QuestaoQuiz entidade) {
        return questaoQuizRepository.save(entidade);
    }

    @Override
    public void apagar(QuestaoQuiz entidade) {

    }

    @Override
    public QuestaoQuiz atualizar(QuestaoQuiz entidade) {
        return questaoQuizRepository.save(entidade);
    }

    @Override
    public QuestaoQuiz find(QuestaoQuiz entidade) {
        return this.find(entidade.getId());
    }

    @Override
    public QuestaoQuiz find(Integer integer) {
        return questaoQuizRepository.findOne(integer);
    }

    @Override
    public List<QuestaoQuiz> findAll() {
        return questaoQuizRepository.findAll();
    }

    @Override
    public QuestaoQuiz findByQuestaoId(Integer id) {
        return questaoQuizRepository.findByQuestaoId(id);
    }
}
