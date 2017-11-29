/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mais.medicos.service;

import mais.medicos.domain.Medico;
import mais.medicos.domain.Paciente;
import mais.medicos.domain.Consulta;

import java.util.List;

/**
 *
 * @author dfranco
 */
public interface ConsultaService extends AbstractService<Consulta, Integer> {


    public List<Consulta> allOfPaciente(Paciente paciente);
    public List<Consulta> allOfMedico(Medico medico);
    
}
