/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.controller;

import java.util.List;

import br.ufg.jatai.fsw.sisquest.model.Aluno;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import br.ufg.jatai.fsw.sisquest.service.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author rafael
 */
@Controller
public class AlunoController implements Serializable{
    
    private static Logger log = LoggerFactory.getLogger(TeamController.class.getName());
    
    @Autowired
    private AlunoServiceImpl AlunoService;  
    
    @ModelAttribute("allAlunos")
    public List<Aluno> populateVisualizarAlunos() {
        return this.AlunoService.findAll();
    }
    
    
    @RequestMapping(value = "/app/aluno")
    public String alunoHome() {
        return "/app/aluno/home";
    }
    
}
