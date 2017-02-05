package br.ufg.jatai.fsw.squest.service;

import br.ufg.jatai.fsw.squest.domain.Alternativa;
import br.ufg.jatai.fsw.squest.repository.AlternativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;


@Service
public class AlternativaServiceImpl implements AlternativaService {

    @Autowired
    private AlternativaRepository alternativaRepository;

    @Override
    public Alternativa inserir(Alternativa entidade) {
        return alternativaRepository.save(entidade);
    }

    @Override
    public void apagar(Alternativa entidade) {

    }

    @Override
    public Alternativa atualizar(Alternativa entidade) {
        return alternativaRepository.save(entidade);
    }

    @Override
    public Alternativa find(Alternativa entidade) {
        return find(entidade.getId());
    }

    @Override
    public Alternativa find(Integer integer) {
        return alternativaRepository.findOne(integer);
    }

    @Override
    public List<Alternativa> findAll() {


        return alternativaRepository.findAll();
    }



}
