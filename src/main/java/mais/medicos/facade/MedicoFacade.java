package mais.medicos.facade;

import mais.medicos.AutenticateUser;
import mais.medicos.controller.ProfessorController;
import mais.medicos.domain.Professor;
import mais.medicos.domain.Turma;
import mais.medicos.email.component.EmailMain;
import mais.medicos.email.domain.EnderecoEletronico;
import mais.medicos.email.domain.FabricaEndereco;
import mais.medicos.email.domain.Mensagem;
import mais.medicos.service.ProfessorService;
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

/**
 * Created by thevilela on 08/01/17.
 */

@Component
public class ProfessorFacade {

    @Autowired
    ProfessorService professorService;

    private static Logger log = LoggerFactory.getLogger(ProfessorController.class.getName());

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
    /**
     * Lista todos os professores
     *
     * @return
     */

    public List<Professor> listarProfessores(){

        log.trace("O usuário " + autenticateUser.getUsuario() + "está listando todos os professores");

        return professorService.findAll();
    }

    /**
     * Insere um novo professor
     *
     * @param professor
     */

    public void inserirProfessor(Professor professor){

        log.trace("O usuário " + autenticateUser.getUsuario() + "está inserindo o professor: " + professor.getNome());

        String gerarSenha = geradorSenha.gerarSenha();
        professor.getUsuario().setSenha(passwordEncoder.encode(gerarSenha));

        professorService.inserir(professor);

        try {

            Mensagem m = new Mensagem();

            ArrayList<EnderecoEletronico> to = new ArrayList<>();

            to.add(fabrica.criaEndereco(professor));

            m.setDestinatarios(to);
            m.setAssunto("Bem-vindo ao SisQuest!");
            m.setCorpo("<h4>Olá, professor " + professor.getNome()
                    + "br>Seu login é: " + professor.getUsuario().getLogin()
                    + "<br>Sua senha é: " + gerarSenha + "</h4>");

          emailMain.sendMail(m);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    /**
     * Atualiza um professor específico
     *
     * @param professor
     */
    public void updateProfessor(Professor professor){

        log.trace("O usuário " + autenticateUser.getUsuario() + "está atualizando o professor: " + professor.getNome());

        professorService.atualizar(professor);

    }

    /**
     * Lista todas as turmas do professor
     *
     * @param professor
     * @return
     */
    public Set<Turma> turmasDoProfessor(Professor professor) {

        log.trace("O usuário " + autenticateUser.getUsuario() + "está listando as turmas do professor: " + professor.getNome());

        return new HashSet<>(professorService.find(professor).getTurmas());

    }

    public Set<Turma> turmasDoProfessor(Integer id){

        log.trace("O usuário " + autenticateUser.getUsuario() + "está listando as turmas do professor: " + professorService.find(id).getNome());

        return new HashSet<>(professorService.find(id).getTurmas());

    }



}