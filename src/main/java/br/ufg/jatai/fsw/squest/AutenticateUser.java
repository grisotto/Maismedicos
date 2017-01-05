package br.ufg.jatai.fsw.squest;

import br.ufg.jatai.fsw.squest.domain.Equipe;
import br.ufg.jatai.fsw.squest.domain.Professor;
import br.ufg.jatai.fsw.squest.domain.Usuario;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Created by dyeimys on 05/01/17.
 */

@Service
public class AutenticateUser {




    public Usuario getUsuario() {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return  (Usuario) user;
    }

    public Professor getProfessor(){

        return getUsuario().getProfessor();
    }

    public Equipe getEquipe(){
        return getUsuario().getEquipe();
    }

}
