/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.service;

import br.ufg.jatai.fsw.squest.domain.Equipe;
import br.ufg.jatai.fsw.squest.domain.Usuario;
import br.ufg.jatai.fsw.squest.repository.EquipeRepository;
import br.ufg.jatai.fsw.squest.util.GeradorSenha;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author vilela
 */
@Service
public class EquipeServiceImpl implements EquipeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EquipeServiceImpl.class);
    @Autowired
    private EquipeRepository equipeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private GeradorSenha geradorSenha;

    @Override
    public Equipe inserir(Equipe entidade) {
        Usuario usuario = new Usuario();
        String gerarSenha = geradorSenha.gerarSenha();
        LOGGER.debug("A senha gerada foi: " + gerarSenha);

        usuario.setLogin(entidade.getNome());
        usuario.setSenha(passwordEncoder.encode(gerarSenha));

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

    @Override
    public List<Equipe> equipesDoProfessor(Integer professorID) {
        return equipeRepository.equipesDoProfessor(professorID);
    }

    @Override
    public Equipe findEquipePorNome(String nome) {

        return equipeRepository.findEqipePorNome(nome);
    }
}
