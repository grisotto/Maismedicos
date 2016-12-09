/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.model.adt;

import br.ufg.jatai.fsw.sisquest.model.Usuario;
import java.util.Date;

/**
 *
 * @author dfranco
 */
public class AdtLog {

    private final TipoLog tipoLog;
    private Date create_at;
    private Usuario usuario;

    public AdtLog(TipoLog tipoLog) {
        this.tipoLog = tipoLog;
    }

    public enum TipoLog     {
        LOGIN
    }
}
