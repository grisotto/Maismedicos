/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.repository;

import br.ufg.jatai.fsw.squest.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dfranco
 */
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    
}
