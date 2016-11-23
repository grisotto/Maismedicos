/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dfranco
 */
@Controller(value = "/")
public class HomeController {

    private static Logger log = LoggerFactory.getLogger(HomeController.class.getName());

    /**
     *
     * @return
     */
    @RequestMapping("/")
    public String home() {
        return "/home/index";
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/sobre")
    public String sobre() {
        return "/home/sobre";
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/entrar")
    public String entrar() {
        return "/home/entrar";
    }

}
