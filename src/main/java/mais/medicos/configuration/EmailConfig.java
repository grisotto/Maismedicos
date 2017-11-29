package br.ufg.jatai.fsw.squest.configuration;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;


@Configuration
public class EmailConfig {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(EmailConfig.class);

    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.port}")
    private String port;
    @Value("${spring.mail.username}")
    private String userName;
    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.default-encoding}")
    private String encoding;


    @Bean
    public JavaMailSender mailService(){

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setJavaMailProperties(getMailProperties());
        mailSender.setHost(host);
        mailSender.setPort(Integer.parseInt(port));

        mailSender.setDefaultEncoding(encoding);
        mailSender.setPassword(password);
        mailSender.setUsername(userName);


        return mailSender;

    }

    public Properties getMailProperties(){

        Properties p = new Properties();

        p.setProperty("mail.smtp.starttls.enable", "true");
        p.setProperty("mail.smtp.port", port);
        p.setProperty("mail.smtp.auth", "true");
        p.setProperty("mail.mime.charset", "utf8");
        p.put("mail.debug", "true");
        p.put("mail.transport.protocol", "smtp");
        p.put("mail.debug.auth", "true");

        return p;

    }

}
