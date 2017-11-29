/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mais.medicos.service;

import mais.medicos.domain.Medico;
import mais.medicos.domain.Paciente;
import mais.medicos.domain.Consulta;
import mais.medicos.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ConsultaServiceImpl implements ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public Consulta inserir(Consulta entidade) {
        return consultaRepository.save(entidade);
    }

    @Override
    public void apagar(Consulta entidade) {
        consultaRepository.delete(entidade);
    }

    @Override
    public Consulta atualizar(Consulta entidade) {
        return consultaRepository.save(entidade);
    }

    @Override
    public Consulta find(Consulta entidade) {
        return find(entidade.getId());
    }

    @Override
    public Consulta find(Integer id) {
        return consultaRepository.findOne(id);
    }

    @Override
    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }


    @Override
    public List<Consulta> allOfPaciente(Paciente paciente) {
        return consultaRepository.findOfPaciente(paciente.getId());
    }

    @Override
    public List<Consulta> allOfMedico(Medico medico) {
        return consultaRepository.findOfMedico(medico.getId());
    }
}
