package mais.medicos;

import mais.medicos.domain.*;
import mais.medicos.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


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



    public Medico getMedico(){

        return getUsuario().getMedico();
    }

    public Paciente getPaciente(){

        return getUsuario().getPaciente();
    }


}
