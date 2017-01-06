/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.facade;

import br.ufg.jatai.fsw.squest.domain.Aluno;
import br.ufg.jatai.fsw.squest.domain.Equipe;
import br.ufg.jatai.fsw.squest.domain.Tarefa;
import br.ufg.jatai.fsw.squest.service.EquipeService;
import br.ufg.jatai.fsw.squest.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author dyeimys
 */
@Component
public class EquipeFacade {

    @Autowired
    private EquipeService equipeService;
    @Autowired
    private TarefaService tarefaService;



    public void adicionaEquipe(Equipe e) {
        equipeService.inserir(e);
    }

    public void addAluno(Aluno aluno, Integer idEquipe){
        Equipe equipe = equipeService.find(idEquipe);
        equipe.add(aluno);
        equipeService.atualizar(equipe);

    }


}
