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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dfranco
 */
@Controller
@RequestMapping("/app")
public class AppController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);
    /**
     * @param model
     * @return
     */
    // tag::findbyusername[]
    @Autowired
    private SessionRegistry sessionRegistry;


    @Autowired
    private AutenticateUser autenticateUser;

    @RequestMapping
    public String index(final Model model) {
        if (autenticateUser.getUsuario().getTipoUsuario().equals(Usuario.TipoUsuario.ADMIN)) {
            List<Object> allPrincipals = this.sessionRegistry.getAllPrincipals();
            List<UserDetails> usuarios = new ArrayList<>();
            for (final Object principal : allPrincipals) {
                if (principal instanceof UserDetails) {
                    final UserDetails user = (UserDetails) principal;
                    usuarios.add(user);
                    LOGGER.info("Usuario: " + user);
                }
            }
            model.addAttribute("usuarios", usuarios);

        }


        LOGGER.info("ENTROU NO CONTROLLER");

        return "/app/dash";
    }


    @ModelAttribute("equipe")
    public Equipe getEquipe() {
        if (autenticateUser.getUsuario().getTipoUsuario().equals(Usuario.TipoUsuario.GRUPO)) {
            LOGGER.info("LOGADO COMO GRUPO");
            return autenticateUser.getEquipe();

        } else {
            return null;
        }
    }

    // Login form
    @RequestMapping("/login")
    public String login() {

        LOGGER.info("Entrou aqui");

        return "login";
    }

    // Login form with error
    @RequestMapping(value = "/logout")
    public void logout(HttpServletRequest request) {
        HttpSession  session = request.getSession(false);
        SecurityContextHolder.clearContext();
        if (session != null) {
            session.invalidate();
        }
    }

    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }
}
