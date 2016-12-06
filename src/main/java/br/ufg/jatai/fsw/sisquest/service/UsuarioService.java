/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.service;

import br.ufg.jatai.fsw.sisquest.model.Usuario;

/**
 *
 * @author dfranco
 */
public interface UsuarioService extends AbstractService<Usuario, Integer> {
    public Usuario usuarioByLogin(String login);
}
