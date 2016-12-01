/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.model.etapas;

import java.util.Date;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author dfranco
 */
@MappedSuperclass
public class EtapaRespondendo extends EtapaEvento {

    /**
     *
     */
    public EtapaRespondendo() {
        super(Etapas.RESPONDENDO);
    }

}
