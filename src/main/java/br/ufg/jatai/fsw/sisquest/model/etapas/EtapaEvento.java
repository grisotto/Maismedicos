/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.model.etapas;

import java.util.Date;

/**
 *
 * @author dfranco
 */
public abstract class EtapaEvento {

    private Date dataInicial;
    private Date dataFinal;
    private final Etapas etapas;

    public EtapaEvento(Etapas etapas) {
        this.etapas = etapas;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

   

    public enum Etapas {
        AGUARDANDO, ESPERANDO_SUBMISSAO, VALIDANDO_QUESTOES, RESPONDENDO, FINALIZADO
    }
}
