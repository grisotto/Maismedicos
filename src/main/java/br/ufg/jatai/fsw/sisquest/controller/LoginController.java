/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.controller;

import br.ufg.jatai.fsw.sisquest.facade.AutenticacaoFacade;
import br.ufg.jatai.fsw.sisquest.model.Usuario;
import br.ufg.jatai.fsw.sisquest.service.UsuarioService;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author dyeimys
 */
@Controller
public class LoginController {
//

    private static Logger log = LoggerFactory.getLogger(LoginController.class.getName());

    @Autowired
    private AutenticacaoFacade facade;

    @GetMapping(value = "/login")
    private String login() {
        log.info("Entrou no controller");
        return "home/login";

    }

    @PostMapping(value = "/login")
    private String login(String login, String senha, HttpSession session, HttpServletResponse response,
            Model model, HttpServletRequest request) throws IOException {

        Usuario u = new Usuario(0, login, senha);
        if (facade.autenicar(u)) {
            return "redirect:/app";
        } else {
            model.addAttribute("erro", "A senha não confere");
            return login();
        }

    }

    @GetMapping(value = "/logout")
    private String logout(HttpSession session) {
        session.removeAttribute("usuarioLogado");
        return this.login();
    }
}
