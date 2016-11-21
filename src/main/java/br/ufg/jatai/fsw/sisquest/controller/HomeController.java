/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dfranco
 */
@RestController(value = "/")
public class HomeController {
   
    
    @GetMapping()
    public String home(){
        return "home";
    }
//    @GetMapping(name = "/sobre")
//    public String sobre(){
//        return "sobre";
//    }
//    @GetMapping(name = "/contato")
//    public String contato(){
//        return "contato";
//    }
//    @GetMapping(name = "/entrar")
//    public String loguin(){
//        return "entrar";
//    }
}
