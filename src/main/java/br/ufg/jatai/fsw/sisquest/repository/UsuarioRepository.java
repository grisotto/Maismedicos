
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.repository;

import br.ufg.jatai.fsw.sisquest.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author dfranco
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "select u from Usuario u where u.login = ?1")
    public Usuario usuarioByLogin(String login);

}
