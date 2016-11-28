/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.controller;

import br.ufg.jatai.fsw.sisquest.dao.PessoaDAO;
import br.ufg.jatai.fsw.sisquest.model.Pessoa;
import br.ufg.jatai.fsw.sisquest.repository.PessoaRepository;
import br.ufg.jatai.fsw.sisquest.repository.PessoaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dfranco
 */
@Controller(value = "/")
public class HomeController {

    private static Logger log = LoggerFactory.getLogger(HomeController.class.getName());

    @Autowired
    private PessoaService p;

    @RequestMapping("/")
    public String home() {
        log.debug("Funcionando");
        p.save(new Pessoa(0, "Noem"));
        return "/home/index";
    }

    @RequestMapping(value = "/sobre")
    public String sobre() {
        return "/home/sobre";
    }

    @RequestMapping(value = "/entrar")
    public String entrar() {
        return "/home/entrar";
    }

}
