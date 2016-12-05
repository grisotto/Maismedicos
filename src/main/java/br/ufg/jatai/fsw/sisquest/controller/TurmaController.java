/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.controller;

import br.ufg.jatai.fsw.sisquest.annotations.Permissao;
import br.ufg.jatai.fsw.sisquest.model.Usuario;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dfranco
 */
@Controller
public class TurmaController implements Serializable {

    private static Logger log = LoggerFactory.getLogger(TurmaController.class.getName());

    /**
     *
     * @return
     */
    @Permissao(Usuario.TipoUsuario.PROFESSOR)
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/app/turma")
    public String turmaHome() {
        return "/app/turma/home";
    }
}
