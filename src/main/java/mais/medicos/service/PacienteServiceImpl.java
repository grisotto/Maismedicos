/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mais.medicos.service;

import mais.medicos.domain.Paciente;
import mais.medicos.repository.PacienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PacienteServiceImpl implements PacienteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PacienteServiceImpl.class);
    /**
     *
     */
    @Autowired
    public PacienteRepository repository;


    @Override
    public Paciente inserir(Paciente entidade) {
        return repository.save(entidade);
    }

    @Override
    public void apagar(Paciente entidade) {
        repository.delete(entidade);
    }

    @Override
    public Paciente atualizar(Paciente entidade) {
        return repository.save(entidade);
    }

    @Override
    public Paciente find(Paciente entidade) {
        return this.find(entidade.getId());
    }

    @Override
    public Paciente find(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public List<Paciente> findAll() {
        return repository.findAll();
    }

}
