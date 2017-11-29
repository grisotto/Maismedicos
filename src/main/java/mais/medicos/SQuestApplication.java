package br.ufg.jatai.fsw.squest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 *
 * @author dyeimys
 */
@SpringBootApplication
public class SQuestApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityUserService.class);

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        LOGGER.debug("Inciando");
        SpringApplication.run(SQuestApplication.class, args);
    }
}
