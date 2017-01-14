/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.facade;

import br.ufg.jatai.fsw.squest.AutenticateUser;
import br.ufg.jatai.fsw.squest.domain.Aluno;
import br.ufg.jatai.fsw.squest.domain.Equipe;
import br.ufg.jatai.fsw.squest.email.component.EmailMain;
import br.ufg.jatai.fsw.squest.email.domain.FabricaEndereco;
import br.ufg.jatai.fsw.squest.email.domain.Mensagem;
import br.ufg.jatai.fsw.squest.service.AlunoService;
import br.ufg.jatai.fsw.squest.service.EquipeService;
import br.ufg.jatai.fsw.squest.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.Iterator;
import java.util.List;

/**
 * @author dyeimys
 */
@Component
public class EquipeFacade {

    @Autowired
    private EquipeService equipeService;
    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private AutenticateUser autenticateUser;
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private EmailMain mailService;
    @Autowired
    private FabricaEndereco fabrica;

    /**
     * Periste um nova tarefa
     *
     * @param e
     */
    public void adicionaEquipe(Equipe e) {
        equipeService.inserir(e);
    }

    /**
     * Adiciona um aluno à equipe
     *
     * @param aluno
     * @param equipe
     */
    public void addAluno(Aluno aluno, Equipe equipe) {

        equipe.add(aluno);
        aluno.getTeams().add(equipe);
//        equipeService.atualizar(equipe);
        alunoService.atualizar(aluno);
    }

    /**
     * Lista todos alunos de uma determinada equipe
     *
     * @param equipe
     * @return
     */
    public List<Aluno> alunosFromEquipe(Equipe equipe) {
        return equipeService.find(equipe.getId()).getAlunos();

    }

    /**
     * Listagem das Equipes do professor.
     *
     * @return
     */
    public List<Equipe> todasEquipesDoProfessor() {
        return this.equipeService.equipesDoProfessor(autenticateUser.getProfessor().getId());

    }

    /**
     * @param id
     * @return
     */
    public Equipe findEquipe(Integer id) {
        return equipeService.find(id);
    }

    public List<Aluno> alunosElegiveisParaEquipe(Integer turmaID) {
        return alunoService.alunosElegiveisParaEquipe(turmaID);

    }

    public boolean existeEquipe(String nome){
        return equipeService.findEquipePorNome(nome)!=null;
    }

    public void ativarEquipe(Integer idEquipe) {

        Equipe equipe = equipeService.find(idEquipe);
        boolean ativa = equipe.isAtiva();
        equipe.setAtiva(!ativa);

        equipeService.atualizar(equipe);

        Mensagem m = new Mensagem();

        Iterator<Aluno> i = equipe.getAlunos().iterator();

        if(equipe.isAtiva()){

            m.setAssunto("A sua equipe está ativa!");

            StringBuilder corpo = new StringBuilder();

            corpo.append("<h4>O professor " + autenticateUser.getProfessor().getNome()
                    + " liberou o acesso da equipe '" + equipe.getNome() + "'."
                    + "<br><br><b>. Membros:");


            while (i.hasNext()){

                Aluno a = i.next();
                corpo.append("<br><br> _ " + a.getNome());

            }

            corpo.append("</b><br><br>PS.: A equipe pode estar logada apenas uma vez!</h4>");

            m.setCorpo(corpo.toString());


        }else{


            m.setAssunto("Bloqueio de acesso da equipe!");

            m.setCorpo("O professor " + autenticateUser.getProfessor().getNome()
                + " bloqueou o acesso da equipe '" + equipe.getNome() + "'!");

        }

        m.setDestinatarios(fabrica.criaEndereco(equipe));

        try {
            mailService.sendMail(m);
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
}
