/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mais.medicos.controller;

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

    private static final Logger log = LoggerFactory.getLogger(HomeController.class.getName());

    /**
     *
     * @return
     */
    @RequestMapping("/")
    public String home() {
        log.debug("Funcionando");
        return "home/index";
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/login")
    public String login() {
        return "home/login";
    }


}
