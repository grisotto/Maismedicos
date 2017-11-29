package mais.medicos.facade;

import mais.medicos.AutenticateUser;
import mais.medicos.controller.MedicoController;
import mais.medicos.domain.Medico;
import mais.medicos.domain.Turma;
import mais.medicos.email.component.EmailMain;
import mais.medicos.email.domain.EnderecoEletronico;
import mais.medicos.email.domain.FabricaEndereco;
import mais.medicos.email.domain.Mensagem;
import mais.medicos.service.MedicoService;
import mais.medicos.util.GeradorSenha;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



@Component
public class MedicoFacade {

    @Autowired
    MedicoService medicoService;

    private static Logger log = LoggerFactory.getLogger(MedicoController.class.getName());

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


    public List<Medico> listarMedicos(){

        log.trace("O usuário " + autenticateUser.getUsuario() + "está listando todos os medicos");

        return medicoService.findAll();
    }



    public void inserirMedico(Medico medico){

        log.trace("O usuário " + autenticateUser.getUsuario() + "está inserindo o medico: " + medico.getNome());

        String gerarSenha = geradorSenha.gerarSenha();
        medico.getUsuario().setSenha(passwordEncoder.encode(gerarSenha));

        medicoService.inserir(medico);

//        try {
//
//            Mensagem m = new Mensagem();
//
//            ArrayList<EnderecoEletronico> to = new ArrayList<>();
//
//            to.add(fabrica.criaEndereco(medico));
//
//            m.setDestinatarios(to);
//            m.setAssunto("Bem-vindo ao SisQuest!");
//            m.setCorpo("<h4>Olá, medico " + medico.getNome()
//                    + "br>Seu login é: " + medico.getUsuario().getLogin()
//                    + "<br>Sua senha é: " + gerarSenha + "</h4>");
//
//          emailMain.sendMail(m);
//
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }

    }


    public void updateMedico(Medico medico){

        log.trace("O usuário " + autenticateUser.getUsuario() + "está atualizando o Medico: " + medico.getNome());

        medicoService.atualizar(medico);

    }


    public Set<Turma> turmasDoMedico(Medico medico) {

        log.trace("O usuário " + autenticateUser.getUsuario() + "está listando as turmas do medico: " + medico.getNome());

        return new HashSet<>(medicoService.find(medico).getTurmas());

    }

    public Set<Turma> turmasDoMedico(Integer id){

        log.trace("O usuário " + autenticateUser.getUsuario() + "está listando as turmas do medico: " + medicoService.find(id).getNome());

        return new HashSet<>(medicoService.find(id).getTurmas());

    }



}
