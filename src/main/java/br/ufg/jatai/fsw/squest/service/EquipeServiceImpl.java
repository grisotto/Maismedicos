/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.service;

import br.ufg.jatai.fsw.squest.domain.Equipe;
import br.ufg.jatai.fsw.squest.domain.Usuario;
import br.ufg.jatai.fsw.squest.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author vilela
 */
@Service
public class EquipeServiceImpl implements EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UsuarioService usuarioService;

    @Override
    public Equipe inserir(Equipe entidade) {
        Usuario usuario = new Usuario();
        
        usuario.setLogin(entidade.getNome());
        usuario.setSenha(passwordEncoder.encode("123"));
        usuario.setTipoUsuario(Usuario.TipoUsuario.GRUPO);
        entidade.setUsuario(usuario);

        Usuario inserir = usuarioService.inserir(usuario);
        entidade.setUsuario(inserir);

        return equipeRepository.save(entidade);
    }

    @Override
    public void apagar(Equipe entidade) {
        equipeRepository.delete(entidade);
    }

    @Override
    public Equipe atualizar(Equipe entidade) {
        return equipeRepository.save(entidade);
    }

    @Override
    public Equipe find(Equipe entidade) {
        return find(entidade.getId());
    }

    @Override
    public Equipe find(Integer id) {
        return equipeRepository.findOne(id);
    }

    @Override
    public List<Equipe> findAll() {
        return equipeRepository.findAll();
    }
    
}
