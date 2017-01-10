package br.ufg.jatai.fsw.squest.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author vilela
 */
@Component
public class EmailMain {


    @Autowired
    private JavaMailSender javaMailSender;

    public void sendAssincrono(Mensagem m) throws MessagingException {

        MimeMessage mensagem = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensagem, true);

        helper.setTo(m.getDestinatario());
        helper.setSubject(m.getAssunto());
        helper.setText(m.getCorpo(),true);

        javaMailSender.send(mensagem);

    }
}
