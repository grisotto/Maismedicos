/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mais.medicos.service;

import mais.medicos.domain.Usuario;

/**
 *
 * @author dfranco
 */
public interface UsuarioService extends AbstractService<Usuario, Integer> {

    /**
     *
     * @param login
     * @return
     */
    public Usuario usuarioForAuth(String login);
}
