/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.ufg.jatai.fsw.squest.repository.PessoaRepository;

/**
 *
 * @author dfranco
 */
@Controller(value = "/")
public class HomeController {

    private static Logger log = LoggerFactory.getLogger(HomeController.class.getName());


    @RequestMapping("/")
    public String home() {
        log.debug("Funcionando");
        return "/home/index";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "/home/login";
    }


}
