/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.controller;

import br.ufg.jatai.fsw.squest.AutenticateUser;
import br.ufg.jatai.fsw.squest.domain.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dfranco
 */
@Controller
public class AppController {

    private static Logger log = LoggerFactory.getLogger(AppController.class.getName());
    @Autowired
    private AutenticateUser autenticateUser;
    /**
     *
     * @return
     */
    @RequestMapping(value = "/app")
    public String index(final ModelMap model) {
        if(autenticateUser.getUsuario().getTipoUsuario().equals(Usuario.TipoUsuario.GRUPO)){
            model.put("equipe",autenticateUser.getEquipe());
        }
        return "/app/dash";
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
