package br.ufg.jatai.fsw.squest.facade;

import br.ufg.jatai.fsw.squest.AutenticateUser;
import br.ufg.jatai.fsw.squest.controller.modelForm.EtapasModel;
import br.ufg.jatai.fsw.squest.domain.EtapaEvento;
import br.ufg.jatai.fsw.squest.domain.Tarefa;
import br.ufg.jatai.fsw.squest.domain.Turma;
import br.ufg.jatai.fsw.squest.service.EtapaEventoService;
import br.ufg.jatai.fsw.squest.service.TarefaService;
import br.ufg.jatai.fsw.squest.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by dyeimys on 06/01/17.
 */
@Component
public class TarefaFacade {

    @Autowired
    private TarefaService tarefaService;
    @Autowired
    private TurmaService turmaService;

    @Autowired
    private AutenticateUser autenticateUser;


    /**
     * Persite uma tarefa
     *
     * @param tarefa
     * @return
     */
    public Tarefa saveTarefa(Tarefa tarefa) {
        return tarefaService.inserir(tarefa);
    }

    /**
     * Listagem das Tarefas cafastras com o professor autenticado.
     *
     * @return
     */
    public List<Tarefa> tarefasFromProessorAuth() {
        return this.tarefaService.allOfProfessor(autenticateUser.getProfessor());

    }

    /**
     * Lista todas as tumas cadastradas no sistma pelo professor ativo
     *
     * @return
     */
    public List<Turma> todasTurmas() {
        return this.turmaService.allOfProfessor(autenticateUser.getProfessor());

    }

    /**
     * Busca por uma turma respectiva pelo ID
     *
     * @param tarefaID id da tarefa
     * @return
     */
    public Tarefa findTarefa(Integer tarefaID) {
        return tarefaService.find(tarefaID);

    }

    /**
     *
     * @param idTarefa
     * @param etapasModel
     */
    public void atualizaDatasEtapas(Integer idTarefa, EtapasModel etapasModel){
        Tarefa find = tarefaService.find(idTarefa);
//        find.getEtapaEventos().clear();
        find.setEtapaAtual(etapasModel.getAguardando());
        find.getEtapaEventos().addAll(etapasModel.buildeLista());

        tarefaService.atualizar(find);
    }
    

    @Autowired
    EtapaEventoService etapaEventoService;

    public void atualizaEtapaAtual(Integer idTarefa, Integer idEtapa) {
        Tarefa tarefa = tarefaService.find(idTarefa);
        EtapaEvento etapaEvento = etapaEventoService.find(idEtapa);
        tarefa.setEtapaAtual(etapaEvento);
        
        tarefaService.atualizar(tarefa);
        
        
    }
}
