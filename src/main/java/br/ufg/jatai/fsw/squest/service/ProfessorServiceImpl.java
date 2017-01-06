/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.service;

import br.ufg.jatai.fsw.squest.domain.Professor;
import br.ufg.jatai.fsw.squest.repository.ProfessorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    public ProfessorRepository repository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Professor inserir(Professor entidade) {
        entidade.getUsuario().setSenha(passwordEncoder.encode(entidade.getUsuario().getSenha()));
        return repository.save(entidade);
    }

    @Override
    public void apagar(Professor entidade) {
        repository.delete(entidade);
    }

    @Override
    public Professor atualizar(Professor entidade) {
        return repository.save(entidade);
    }

    @Override
    public Professor find(Professor entidade) {
        return this.find(entidade.getId());
    }

    @Override
    public Professor find(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public List<Professor> findAll() {
        return repository.findAll();
    }

}
