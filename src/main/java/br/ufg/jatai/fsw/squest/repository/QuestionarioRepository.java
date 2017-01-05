/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.repository;

import br.ufg.jatai.fsw.squest.domain.Questionario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author vilela
 */
public interface QuestionarioRepository extends JpaRepository<Questionario, Integer> {
    
}
