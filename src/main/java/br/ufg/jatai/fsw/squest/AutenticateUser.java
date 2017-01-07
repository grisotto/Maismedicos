package br.ufg.jatai.fsw.squest;

import br.ufg.jatai.fsw.squest.domain.Equipe;
import br.ufg.jatai.fsw.squest.domain.Professor;
import br.ufg.jatai.fsw.squest.domain.Usuario;
import br.ufg.jatai.fsw.squest.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Created by dyeimys on 05/01/17.
 */

@Service
public class AutenticateUser {
    private static final Logger LOGGER = LoggerFactory.getLogger(AutenticateUser.class);

    @Autowired
    private UsuarioService usuarioService;

    /**
     *
     * @return
     */
    public Usuario getUsuario() {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return  (Usuario) usuarioService.usuarioForAuth(user.getUsername());
    }

    /**
     *
     * @return
     */
    public Professor getProfessor(){

        return getUsuario().getProfessor();
    }

    /**
     *
     * @return
     */
    public Equipe getEquipe(){
        LOGGER.info("Equipe"+
        getUsuario().getEquipe());
        return getUsuario().getEquipe();
    }

}
