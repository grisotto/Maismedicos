/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.service;

import br.ufg.jatai.fsw.sisquest.model.Usuario;
import br.ufg.jatai.fsw.sisquest.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    public UsuarioRepository repository;

    @Override
    public Usuario usuarioForAuth(String login, String senha) {
        return repository.userForAuth(login, senha);
    }

    @Override
    public Usuario inserir(Usuario entidade) {
        return repository.save(entidade);
    }

    @Override
    public void apagar(Usuario entidade) {
        repository.delete(entidade);
    }

    @Override
    public Usuario atualizar(Usuario entidade) {
        return repository.save(entidade);
    }

    @Override
    public Usuario find(Usuario entidade) {
        return this.find(entidade.getId());
    }

    @Override
    public Usuario find(Integer id) {
        return repository.findOne(id);

    }

    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
    }

}
