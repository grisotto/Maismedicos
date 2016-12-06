/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.facade;

import br.ufg.jatai.fsw.sisquest.SessaoUsuario;
import br.ufg.jatai.fsw.sisquest.model.Usuario;
import br.ufg.jatai.fsw.sisquest.service.UsuarioService;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dfranco
 */
@Component
public class AutenticacaoFacade implements Serializable {
    
    private static final long serialVersionUID = 4345166249833927726L;
    
    @Autowired
    private UsuarioService service;
    
    @Autowired
    private SessaoUsuario sessaoUsuario;
    
    public boolean autenicar(Usuario usuario) {
        
        Usuario u = service.usuarioForAuth(usuario.getLogin(), usuario.getSenha());
        if (u == null) {
            return false;
        } else {
            sessaoUsuario.entrar(u);
            return true;
        }
        
    }
}
