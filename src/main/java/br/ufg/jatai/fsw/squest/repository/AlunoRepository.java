/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.repository;

import br.ufg.jatai.fsw.squest.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vilela
 */
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    
    public Aluno findByEmail(String email);
    public Aluno findByMatricula(String matricula);
}
