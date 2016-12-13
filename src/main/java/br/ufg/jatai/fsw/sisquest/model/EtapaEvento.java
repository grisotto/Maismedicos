/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author dfranco
 */
@Entity
@Table
@SuppressWarnings("PersistenceUnitPresent")
public class EtapaEvento implements Serializable {

    private static final long serialVersionUID = 4456862572499658619L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicial;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFinal;

    @Enumerated(EnumType.STRING)
    private TipoEtapa tipo;

    @ManyToMany(mappedBy = "etapaEventos")
    private List<Tarefa> tarefas;

    public EtapaEvento() {
        this.tipo = null;
    }

    /**
     *
     * @param tipo
     */
    public EtapaEvento(TipoEtapa tipo) {
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public TipoEtapa getTipo() {
        return tipo;
    }

    public void setTipo(TipoEtapa tipo) {
        this.tipo = tipo;
    }

    /**
     *
     */
    public enum TipoEtapa {

        /**
         *
         */
        AGUARDANDO {

                    @Override
                    public Integer id() {
                        return 1;
                    }

                    @Override
                    public String toString() {
                        return "Aguardando";
                    }
                },
        /**
         *
         */
        ESPERANDO_SUBMISSAO {

                    @Override
                    public Integer id() {
                        return 2;
                    }

                    @Override
                    public String toString() {
                        return "Esperando Submissão";
                    }
                },
        /**
         *
         */
        VALIDANDO_QUESTOES {

                    @Override
                    public Integer id() {
                        return 3;
                    }

                    @Override
                    public String toString() {
                        return "Validando Questões";
                    }
                },
        /**
         *
         */
        RESPONDENDO {

                    @Override
                    public Integer id() {
                        return 4;
                    }

                    @Override
                    public String toString() {
                        return "Respodendo";
                    }
                },
        /**
         *
         */
        FINALIZADO {

                    @Override
                    public Integer id() {
                        return 5;
                    }

                    @Override
                    public String toString() {
                        return "Finalizado";
                    }

                };

        public abstract Integer id();

        @Override
        public abstract String toString();

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 50 * hash + Objects.hashCode(this.dataInicial);
        hash = 50 * hash + Objects.hashCode(this.dataFinal);
        hash = 50 * hash + Objects.hashCode(this.tipo);
        hash = 50 * hash + Objects.hashCode(this.tarefas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EtapaEvento other = (EtapaEvento) obj;
        if (!Objects.equals(this.dataInicial, other.dataInicial)) {
            return false;
        }
        if (!Objects.equals(this.dataFinal, other.dataFinal)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        if (!Objects.equals(this.tarefas, other.tarefas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EtapaEvento{" + "dataInicial=" + dataInicial + ", dataFinal=" + dataFinal + ", tipo=" + tipo + '}';
    }

}
