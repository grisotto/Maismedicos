
//package br.ufg.jatai.fsw.squest.email;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Component;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//
///**
// * @author vilela
// */
//@Component
//public class EmailMain {
//
//
//    @Autowired
//    private JavaMailSender javaMailSender;
//
//    public void sendAssincrono(Mensagem m) throws MessagingException {
//
//        MimeMessage mensagem = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(mensagem, true);
//
//        helper.setTo(m.getDestinatario());
//        helper.setSubject(m.getAssunto());
//        helper.setText(m.getCorpo(),true);
//
//        javaMailSender.send(mensagem);
//
//    }
//}

package br.ufg.jatai.fsw.squest.email.component;

import br.ufg.jatai.fsw.squest.email.domain.EnderecoEletronico;
import br.ufg.jatai.fsw.squest.email.domain.Mensagem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Iterator;

/**
 * @author vilela
 */
@Component
public class EmailMain {

    private static Logger log = LoggerFactory.getLogger(EmailMain.class.getName());

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${fsw.email.ativo}")
    private boolean ativo;

    public void sendMail(Mensagem m) throws MessagingException {
        log.info("Email Ativo: "+ativo);
        if(isAtivo()){

            MimeMessage mensagem = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mensagem, true);
            helper.setFrom("squest@jataiufg.net");
            helper.setSubject(m.getAssunto());
            helper.setText(m.getCorpo(),true);

            Iterator<EnderecoEletronico> iD = m.getDestinatarios().iterator();

            while (iD.hasNext()){

                EnderecoEletronico e = iD.next();

                helper.addTo(e.getEmail());

            }

            Iterator<EnderecoEletronico> iB = m.getBcc().iterator();

            while (iB.hasNext()){

                EnderecoEletronico e = iB.next();

                helper.addBcc(e.getEmail());

            }

            Iterator<EnderecoEletronico> iC = m.getCc().iterator();

            while (iC.hasNext()){

                EnderecoEletronico e = iC.next();

                helper.addCc(e.getEmail());

            }


            javaMailSender.send(mensagem);

        } else {

            log.info("O envio de mensagens não está ativo.");
            log.info("Mensagem: "+m);

        }


    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isAtivo(){
        return this.ativo;
    }



}

