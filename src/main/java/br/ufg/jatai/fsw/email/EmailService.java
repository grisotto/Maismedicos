/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 *
 * @author vilela
 */

@Component
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void enviaEmail(Mensagem m) throws MessagingException, InterruptedException {

        Thread.sleep(1000);

        MimeMessage mensagem = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensagem, true);

        for (String destinatario : m.getDestinatarios()){
            helper.addTo(destinatario);
        }

        for (String bcc : m.getBcc()){
            helper.addBcc(bcc);
        }

        for (File anexo : m.getAnexos()){
            helper.addAttachment(anexo.getName(), anexo);
        }

        helper.setSubject(m.getAssunto());
        helper.setText(m.getCorpo());

        javaMailSender.send(mensagem);

    }
    
}
