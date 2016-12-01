/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.model.etapas;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author dfranco
 */
@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "etapas")
@SuppressWarnings("PersistenceUnitPresent")
public abstract class EtapaEvento implements Serializable {

    @Id
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicial;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFinal;

    @Enumerated(EnumType.STRING)
    private final Etapas etapas;

    public EtapaEvento() {
        this.etapas = null;
    }

    /**
     *
     * @param etapas
     */
    public EtapaEvento(Etapas etapas) {
        this.etapas = etapas;
    }

    /**
     *
     * @return
     */
    public Date getDataInicial() {
        return dataInicial;
    }

    /**
     *
     * @param dataInicial
     */
    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    /**
     *
     * @return
     */
    public Date getDataFinal() {
        return dataFinal;
    }

    /**
     *
     * @param dataFinal
     */
    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Etapas getEtapas() {
        return etapas;
    }

    /**
     *
     */
    public enum Etapas {

        /**
         *
         */
        AGUARDANDO,
        /**
         *
         */
        ESPERANDO_SUBMISSAO,
        /**
         *
         */
        VALIDANDO_QUESTOES,
        /**
         *
         */
        RESPONDENDO,
        /**
         *
         */
        FINALIZADO
    }
}
