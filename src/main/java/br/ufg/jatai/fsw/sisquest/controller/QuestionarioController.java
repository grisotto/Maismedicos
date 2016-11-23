/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.controller;

import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dfranco
 */
@Controller
public class QuestionarioController implements Serializable {
    private static Logger log = LoggerFactory.getLogger(QuestionarioController.class.getName());

    @RequestMapping(value = "/app/questionario")
    public String turmaHome() {
        return "/app/questionario/home";
    }
}
