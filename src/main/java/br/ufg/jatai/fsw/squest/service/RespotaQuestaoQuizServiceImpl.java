package br.ufg.jatai.fsw.squest.service;

import br.ufg.jatai.fsw.squest.domain.quis.RespotaQuestaoQuiz;
import br.ufg.jatai.fsw.squest.repository.RespotaQuestaoQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespotaQuestaoQuizServiceImpl implements RespotaQuestaoQuizService {

    @Autowired
    private RespotaQuestaoQuizRepository respotaQuestaoQuizRepository;
    @Override
    public RespotaQuestaoQuiz inserir(RespotaQuestaoQuiz entidade) {
        return respotaQuestaoQuizRepository.save(entidade);
    }

    @Override
    public void apagar(RespotaQuestaoQuiz entidade) {

    }

    @Override
    public RespotaQuestaoQuiz atualizar(RespotaQuestaoQuiz entidade) {
        return respotaQuestaoQuizRepository.save(entidade);
    }

    @Override
    public RespotaQuestaoQuiz find(RespotaQuestaoQuiz entidade) {
        return this.find(entidade.getId());
    }

    @Override
    public RespotaQuestaoQuiz find(Integer integer) {
        return respotaQuestaoQuizRepository.findOne(integer);
    }

    @Override
    public List<RespotaQuestaoQuiz> findAll() {
        return respotaQuestaoQuizRepository.findAll();
    }
}
