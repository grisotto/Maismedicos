/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dfranco
 */
@Controller(value = "/")
public class HomeController {
   
    
    @RequestMapping("/")
    public String home(){
        return "WEB-INF/views/home/index.jsp";
    }
    @RequestMapping(value = "/sobre")
    public String sobre(){
        return "WEB-INF/views/home/sobre.jsp";
    }
    @RequestMapping(value = "/entrar")
    public String entrar(){
        return "WEB-INF/views/home/entrar.jsp";
    }

}
