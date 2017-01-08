package br.ufg.jatai.fsw.squest.facade;

import br.ufg.jatai.fsw.squest.AutenticateUser;
import br.ufg.jatai.fsw.squest.controller.AlunoController;
import br.ufg.jatai.fsw.squest.controller.ProfessorController;
import br.ufg.jatai.fsw.squest.domain.Professor;
import br.ufg.jatai.fsw.squest.service.ProfessorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public List<Professor> listarProfessores(){
        return professorService.findAll();
    }

    public void inserirProfessor(Professor professor){

        professorService.inserir(professor);

    }

    public void updateProfessor(Professor professor){

        professorService.atualizar(professor);

    }

    


}
