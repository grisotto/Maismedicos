package br.ufg.jatai.fsw.squest.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by thevilela on 10/01/17.
 */

@Configuration
public class EmailConfiguration {

    @Value("spring.mail.host")
    private String host;
    @Value("spring.mail.port")
    private String port;
    @Value("spring.mail.username")
    private String userName;
    @Value("spring.mail.password")
    private String password;

    


}
