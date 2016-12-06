/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.repository;

import br.ufg.jatai.fsw.sisquest.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author vilela
 */
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
