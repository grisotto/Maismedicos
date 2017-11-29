/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mais.medicos.configuration;

import mais.medicos.domain.*;
import mais.medicos.service.*;
import mais.medicos.util.GeradorSenha;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author dyeimys
 */
@Configuration
public class DataBaseConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataBaseConfig.class);

    /**
     *
     * @return
     */
//    @Bean
//    public DataSource dataSourceH2() {
//        DataSource build = DataSourceBuilder.create()
//                .driverClassName("org.h2.Driver")
//                .username("su")
//                .password("")
//                .url("jdbc:h2:mem:~/squest")
//                .build();
//        return build;
//    }

    @Component
    class DataLoader implements ApplicationRunner {

        private final Logger LOGGER = LoggerFactory.getLogger(DataLoader.class);

        @Autowired
        private UsuarioService usuarioService;


        @Autowired
        private PacienteService pacienteService;
        @Autowired
        private MedicoService medicoService;


    @Autowired
    private GeradorSenha geradorSenha;


        @Autowired
        private PasswordEncoder passwordEncoder;

//        @Value("${fsw.inicializadb}")
        @Override
        public void run(ApplicationArguments args) throws Exception {
            LOGGER.info("RUN in ApplicationRunner");







             Usuario u = new Usuario("admin", "admin");
            u.setSenha(passwordEncoder.encode("1234"));
//            u.setSenha("1234");

             u.setTipoUsuario(Usuario.TipoUsuario.ADMIN);

             LOGGER.info("Inserindo ADMIN:" + u);
             usuarioService.inserir(u);




             Paciente p1 = new Paciente();
             p1.setNome("Algusto");
             p1.setEmail("adfad@email.com");
             p1.setUsuario(
                     new Usuario("algusto",
                             passwordEncoder.encode("1234"),
                     Usuario.TipoUsuario.PACIENTE));

            Paciente paciente = pacienteService.inserir(p1);


            Paciente p2 = new Paciente();
            p2.setNome("Maria Betania");
            p2.setEmail("mariabetania@email.com");
            p2.setUsuario(
                    new Usuario("maria",
                            passwordEncoder.encode("1234"),
                            Usuario.TipoUsuario.PACIENTE));

            Paciente paciente2 = pacienteService.inserir(p2);



            Medico m = new Medico();
            m.setNome("Rafael Pereira");
            m.setEmail("pereiraa@email.com");
            m.setUsuario(
                    new Usuario("rafaelp",
                            passwordEncoder.encode("1234"),
                            Usuario.TipoUsuario.MEDICO));

            Medico medico = medicoService.inserir(m);



            Medico m2 = new Medico();
            m2.setNome("Milton Pereira");
            m2.setEmail("milton@email.com");
            m2.setUsuario(
                    new Usuario("milton",
                            passwordEncoder.encode("1234"),
                            Usuario.TipoUsuario.MEDICO));

            Medico medico2 = medicoService.inserir(m2);

//             Turma t = new Turma();
//             t.setNome("Turma 1");
//             t.setDescricao("Tuma numero 01");
//             t.setProfessor(professor);
//
//             LOGGER.info("Inserindo T1: " + t);
//             turmaService.inserir(t);
//
//             Tarefa taf = new Tarefa();
//             taf.setTurma(t);
//             taf.setDescricao("Muita coisa acontecendo nesta cidade");
//             taf.setTitulo("Atividade primeiro semestre");
//             taf.setTamanhoQuestoes(5);
//             tarefaService.inserir(taf);

            

            LOGGER.info("LOCALE DEFAULT: " + LocaleContextHolder.getLocale());
            LOGGER.info("DATATIME ATUAL: " + new Date(System.currentTimeMillis()));

        }
    }
}
