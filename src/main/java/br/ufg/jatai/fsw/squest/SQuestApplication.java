package br.ufg.jatai.fsw.squest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@SpringBootApplication
public class SQuestApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityUserService.class);

    public static void main(String[] args) {
        SpringApplication.run(SQuestApplication.class, args);
    }
}
