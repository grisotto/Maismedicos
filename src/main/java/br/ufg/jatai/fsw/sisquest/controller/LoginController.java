/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.controller;

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
    private UsuarioService service;

    @GetMapping(value = "/login")
    private String login() {
        log.info("Entrou no controller");
        return "home/login";

    }

    @PostMapping(value = "/login")
    private String login(String login, String senha, HttpSession session, HttpServletResponse response,
            Model model, HttpServletRequest request) throws IOException {
        String parameter = request.getParameter("u");
        log.error("Enrou no postLogin");
        log.error("parameter: " + parameter);

        Usuario usuarioByLogin = service.usuarioByLogin(login);

        if (usuarioByLogin != null) {
            log.error("O usuario existe");
            if (usuarioByLogin.getSenha().equals(senha)) {
                log.error("A senha confere: " + senha + " - " + usuarioByLogin.getSenha());
                session.setAttribute("usuarioLogado", usuarioByLogin);
                response.sendRedirect("/app");

            } else {
                log.error("A senha nao confere: " + senha + " - " + usuarioByLogin.getSenha());
                model.addAttribute("erro", "A senha não confere");
                return this.login();
            }
        } else {
            log.error("Usuario nao existe");

            model.addAttribute("erro", "Usuario não existe");
            return this.login();
        }
        return "/app/dash";
    }

    @GetMapping(value = "/logout")
    private String logout(HttpSession session) {
        session.removeAttribute("usuarioLogado");
        return this.login();
    }
}
