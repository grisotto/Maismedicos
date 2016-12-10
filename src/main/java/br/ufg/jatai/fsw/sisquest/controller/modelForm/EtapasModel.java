/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.controller.modelForm;

import br.ufg.jatai.fsw.sisquest.model.EtapaEvento;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import org.hibernate.internal.util.compare.ComparableComparator;

/**
 *
 * @author dyeimys
 */
public class EtapasModel {

    private EtapaEvento aguardando;
    private EtapaEvento esperandoSubmissao;
    private EtapaEvento validandoQuestoes;
    private EtapaEvento respondendo;
    private EtapaEvento finalizado;

    public EtapaEvento getAguardando() {
        return aguardando;
    }

    public void setAguardando(EtapaEvento aguardando) {
        aguardando.setTipo(EtapaEvento.TipoEtapa.AGUARDANDO);
        this.aguardando = aguardando;
    }

    public EtapaEvento getEsperandoSubmissao() {

        return esperandoSubmissao;
    }

    public void setEsperandoSubmissao(EtapaEvento esperandoSubmissao) {
        esperandoSubmissao.setTipo(EtapaEvento.TipoEtapa.ESPERANDO_SUBMISSAO);
        this.esperandoSubmissao = esperandoSubmissao;
    }

    public EtapaEvento getValidandoQuestoes() {
        return validandoQuestoes;
    }

    public void setValidandoQuestoes(EtapaEvento validandoQuestoes) {
        validandoQuestoes.setTipo(EtapaEvento.TipoEtapa.VALIDANDO_QUESTOES);
        this.validandoQuestoes = validandoQuestoes;
    }

    public EtapaEvento getRespondendo() {
        return respondendo;
    }

    public void setRespondendo(EtapaEvento respondendo) {
        respondendo.setTipo(EtapaEvento.TipoEtapa.RESPONDENDO);
        this.respondendo = respondendo;
    }

    public EtapaEvento getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(EtapaEvento finalizado) {
        finalizado.setTipo(EtapaEvento.TipoEtapa.FINALIZADO);
        this.finalizado = finalizado;
    }

    public List<EtapaEvento> buildeLista() {
        List<EtapaEvento> retorno = new ArrayList<EtapaEvento>();
        retorno.add(aguardando);
        retorno.add(esperandoSubmissao);
        retorno.add(validandoQuestoes);
        retorno.add(respondendo);
        retorno.add(finalizado);
        retorno.sort(new Comparator<EtapaEvento>() {
            @Override
            public int compare(EtapaEvento o1, EtapaEvento o2) {
                if (o1.getTipo().id() > o2.getTipo().id()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        return retorno;
    }

    public EtapasModel buildeOvjeto(Set<EtapaEvento> em) {

        EtapasModel retorno = new EtapasModel();
        

        for (EtapaEvento e : em) {
            if (e.getTipo().equals(EtapaEvento.TipoEtapa.AGUARDANDO)) {
                retorno.setAguardando(e);
            } else if (e.getTipo().equals(EtapaEvento.TipoEtapa.ESPERANDO_SUBMISSAO)) {
                retorno.setEsperandoSubmissao(e);
            } else if (e.getTipo().equals(EtapaEvento.TipoEtapa.VALIDANDO_QUESTOES)) {
                retorno.setValidandoQuestoes(e);
            } else if (e.getTipo().equals(EtapaEvento.TipoEtapa.RESPONDENDO)) {
                retorno.setRespondendo(e);
            } else if (e.getTipo().equals(EtapaEvento.TipoEtapa.FINALIZADO)) {
                retorno.setFinalizado(e);
            }
        }
        return retorno;
    }

    public EtapasModel buildeOvjeto(List<EtapaEvento> em) {
        EtapasModel retorno = new EtapasModel();
        for (EtapaEvento e : em) {
            if (e.getTipo().equals(EtapaEvento.TipoEtapa.AGUARDANDO)) {
                retorno.setAguardando(e);
            } else if (e.getTipo().equals(EtapaEvento.TipoEtapa.ESPERANDO_SUBMISSAO)) {
                retorno.setEsperandoSubmissao(e);
            } else if (e.getTipo().equals(EtapaEvento.TipoEtapa.VALIDANDO_QUESTOES)) {
                retorno.setValidandoQuestoes(e);
            } else if (e.getTipo().equals(EtapaEvento.TipoEtapa.RESPONDENDO)) {
                retorno.setRespondendo(e);
            } else if (e.getTipo().equals(EtapaEvento.TipoEtapa.FINALIZADO)) {
                retorno.setFinalizado(e);
            }
        }
        return retorno;
    }
}
