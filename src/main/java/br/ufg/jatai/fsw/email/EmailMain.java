/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author vilela
 */

@Component
public class EmailMain {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendAssincrono(Mensagem m) throws MessagingException {


    }

    public void sendSincrono(Mensagem m) throws MessagingException {



    }
    
}
