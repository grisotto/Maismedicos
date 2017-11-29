/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mais.medicos.facade;

import mais.medicos.AutenticateUser;
import mais.medicos.domain.*;
import mais.medicos.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class ConsultaFacade implements Serializable {

    @Autowired
    private ConsultaService consultaService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private MedicoService medicoService;
    @Autowired
    private AutenticateUser autenticateUser;

    /**
     *
     */
    public ConsultaFacade() {

    }


    @Deprecated
    public List<Consulta> consultasOfPaciente(Paciente paciente) {
        return consultaService.allOfPaciente(paciente);
    }

    @Deprecated
    public List<Consulta> consultasOfMedico(Medico medico) {
        return consultaService.allOfMedico(medico);
    }


    public List<Consulta> consultasOfPaciente() {
        return this.consultasOfPaciente(autenticateUser.getPaciente());
    }


    public List<Consulta> consultasOfMedico() {
        return this.consultasOfMedico(autenticateUser.getMedico());
    }


    public Consulta createConsulta(Consulta consulta, Integer idMedico) {
        //set o paciente e escolhe o medico
        consulta.setPaciente(autenticateUser.getPaciente());
        consulta.setMedico(medicoService.find(idMedico));
        return consultaService.inserir(consulta);
    }

    /**
     *
     * @param id
     * @return
     */
    public Consulta findConsulta(Integer id) {
        return consultaService.find(id);
    }

//
//    public Turma insertAluno(Consulta consulta, Aluno aluno) {
//        turma.getAlunos().add(aluno);
//        return consultaService.atualizar(consulta);
//    }
//
//
//    public Turma insertAluno(Integer idTurma, Integer idAluno) {
//        return this.insertAluno(
//                consultaService.find(idTurma),
//                alunoService.find(idAluno)
//        );
//    }

    /**
     *
     * @return
     */
    public List<Consulta> tarefasOfPaciente() {
        return consultaService.allOfPaciente(autenticateUser.getPaciente());
    }

    public List<Consulta> tarefasOfMedico() {
        return consultaService.allOfMedico(autenticateUser.getMedico());
    }

}
