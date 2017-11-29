/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mais.medicos.service;

import mais.medicos.domain.Medico;
import mais.medicos.repository.MedicoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MedicoServiceImpl implements MedicoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MedicoServiceImpl.class);
    /**
     *
     */
    @Autowired
    public MedicoRepository repository;


    @Override
    public Medico inserir(Medico entidade) {
        return repository.save(entidade);
    }

    @Override
    public void apagar(Medico entidade) {
        repository.delete(entidade);
    }

    @Override
    public Medico atualizar(Medico entidade) {
        return repository.save(entidade);
    }

    @Override
    public Medico find(Medico entidade) {
        return this.find(entidade.getId());
    }

    @Override
    public Medico find(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public List<Medico> findAll() {
        return repository.findAll();
    }

}
