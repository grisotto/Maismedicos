package br.ufg.jatai.fsw.sisquest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "br.ufg.jatai.fsw.sisquest")
public class AppConfig {

}