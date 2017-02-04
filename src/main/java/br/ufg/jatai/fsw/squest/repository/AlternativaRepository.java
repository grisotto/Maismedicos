/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.repository;

import br.ufg.jatai.fsw.squest.domain.Alternativa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * @author dfranco
 */
public interface AlternativaRepository extends JpaRepository<Alternativa, Integer> {



    
}
