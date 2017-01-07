/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.controller;

import br.ufg.jatai.fsw.squest.AutenticateUser;
import br.ufg.jatai.fsw.squest.domain.Equipe;
import br.ufg.jatai.fsw.squest.domain.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dfranco
 */
@Controller
@RequestMapping("/app")
public class AppController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @Autowired
    private AutenticateUser autenticateUser;

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping
    public String index(final Model model) {
        LOGGER.info("ENTROU NO CONTROLLER");

        return "/app/dash";
    }

    
    @ModelAttribute("equipe")
    public Equipe getEquipe() {
        if (autenticateUser.getUsuario().getTipoUsuario().equals(Usuario.TipoUsuario.GRUPO)) {
            LOGGER.info("LOGADO COMO GRUPO");
           return autenticateUser.getEquipe();

        }
        else{
            return null;
        }
    }

    // Login form
    @RequestMapping("/login.html")
    public String login() {
        return "login.html";
    }
    // Login form with error

    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }
}
