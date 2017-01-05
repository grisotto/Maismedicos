/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.configuration;

import br.ufg.jatai.fsw.squest.domain.Aluno;
import br.ufg.jatai.fsw.squest.domain.Professor;
import br.ufg.jatai.fsw.squest.domain.Turma;
import br.ufg.jatai.fsw.squest.domain.Usuario;
import br.ufg.jatai.fsw.squest.service.AlunoService;
import br.ufg.jatai.fsw.squest.service.ProfessorService;
import br.ufg.jatai.fsw.squest.service.TurmaService;
import br.ufg.jatai.fsw.squest.service.UsuarioService;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author dyeimys
 */
@Configuration
public class DataBaseConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataBaseConfig.class);


    @Bean
    public DataSource dataSourceH2() {
        DataSource build = DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .username("su")
                .password("")
                .url("jdbc:h2:mem:~/squest")
                .build();
        return build;
    }

    @Component
    class DataLoader implements ApplicationRunner {

        private final Logger LOGGER = LoggerFactory.getLogger(DataLoader.class);

        @Autowired
        private UsuarioService usuarioService;
        @Autowired
        private AlunoService alunoService;

        @Autowired
        private ProfessorService professorService;

        @Autowired
        private TurmaService turmaService;

        @Override
        public void run(ApplicationArguments args) throws Exception {
            LOGGER.info("RUN in ApplicationRunner");


            Aluno a1 = new Aluno();
            a1.setEmail("jose@email.com");
            a1.setMatricula("1245");
            a1.setNome("José Antonio");

            Aluno a2 = new Aluno();
            a2.setEmail("maria@email.com");
            a2.setMatricula("12469");
            a2.setNome("Maria José");

            Aluno a3 = new Aluno();
            a3.setEmail("pedro@email.com");
            a3.setMatricula("9438");
            a3.setNome("Pesro Silva");

            Aluno a4 = new Aluno();
            a4.setEmail("aparecida@email.com");
            a4.setMatricula("63853");
            a4.setNome("Aparecida Antonio");


            Usuario u = new Usuario("admin", "admin");
            u.setSenha("123");
            u.setTipoUsuario(Usuario.TipoUsuario.ADMIN);

            LOGGER.info("Inserindo ADMIN:" + u);
            usuarioService.inserir(u);

            LOGGER.info("Inserindo A1" + a1);
            alunoService.inserir(a1);

            LOGGER.info("Inserindo A2" + a2);
            alunoService.inserir(a2);

            LOGGER.info("Inserindo A3" + a3);
            alunoService.inserir(a3);

            LOGGER.info("Inserindo A4" + a4);
            alunoService.inserir(a4);

            Professor p = new Professor();
            p.setNome("Professor Algusto");
            p.setEmail("professor@email.com");
            p.setUsuario(new Usuario("professor", "123", Usuario.TipoUsuario.PROFESSOR));
            LOGGER.info("Inserindo P1" + p);
            Professor professor = professorService.inserir(p);

            Turma t = new Turma();
            t.setNome("Turma 1");
            t.setDescricao("Tuma numero 01");
            t.setProfessor(professor);

            LOGGER.info("Inserindo T1: " + t);
            turmaService.inserir(t);

            LOGGER.info("LOCALE DEFAULT: " + LocaleContextHolder.getLocale());
            LOGGER.info("DATATIME ATUAL: " + new Date(System.currentTimeMillis()));

        }
    }
}
