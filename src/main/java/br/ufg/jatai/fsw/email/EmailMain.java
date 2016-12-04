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

        int qtdDestinatarios = m.getDestinatarios().size();
        int qtdBcc = m.getBcc().size();
        int qtdAnexos = m.getAnexos().size();

        MimeMessage mensagem = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensagem, true);

        for (int i = 0; i < qtdDestinatarios; i++){
            helper.addTo(m.getDestinatarios().get(i));
        }

        for (int i = 0; i < qtdBcc; i++){
            helper.addBcc(m.getBcc().get(i));
        }

        for (int i = 0; i < qtdAnexos; i++){
            helper.addAttachment(m.getAnexos().get(i).getName(),m.getAnexos().get(i));
        }

        helper.setSubject(m.getAssunto());
        helper.setText(m.getCorpo());

        javaMailSender.send(mensagem);

    }
    
}
