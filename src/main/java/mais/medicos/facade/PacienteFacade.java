package mais.medicos.facade;

import mais.medicos.AutenticateUser;
import mais.medicos.controller.PacienteController;
import mais.medicos.domain.Paciente;
import mais.medicos.email.component.EmailMain;
import mais.medicos.email.domain.FabricaEndereco;
import mais.medicos.service.PacienteService;
import mais.medicos.util.GeradorSenha;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
public class PacienteFacade {

    @Autowired
    PacienteService pacienteService;

    private static Logger log = LoggerFactory.getLogger(PacienteController.class.getName());

    @Autowired
    private AutenticateUser autenticateUser;

    @Autowired
    private GeradorSenha geradorSenha;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private EmailMain emailMain;

    @Autowired
    private FabricaEndereco fabrica;


    public List<Paciente> listarPacientes(){

        log.trace("O usuário " + autenticateUser.getUsuario() + "está listando todos os Paciente");

        return pacienteService.findAll();
    }



    public void inserirPaciente(Paciente paciente){

        log.trace("O usuário " + autenticateUser.getUsuario() + "está inserindo o Paciente: " + paciente.getNome());

        String gerarSenha = geradorSenha.gerarSenha();
        paciente.getUsuario().setSenha(passwordEncoder.encode(gerarSenha));

        pacienteService.inserir(paciente);


    }


    public void updatePaciente(Paciente paciente){

        log.trace("O usuário " + autenticateUser.getUsuario() + "está atualizando o paciente: " + paciente.getNome());

        pacienteService.atualizar(paciente);

    }


//    public Set<Turma> turmasDoPaciente(Paciente paciente) {
//
//        log.trace("O usuário " + autenticateUser.getUsuario() + "está listando as turmas do paciente: " + paciente.getNome());
//
//        return new HashSet<>(pacienteService.find(paciente).getTurmas());
//
//    }
//
//    public Set<Turma> turmasDoPaciente(Integer id){
//
//        log.trace("O usuário " + autenticateUser.getUsuario() + "está listando as turmas do paciente: " + pacienteService.find(id).getNome());
//
//        return new HashSet<>(pacienteService.find(id).getTurmas());
//
//    }



}
