/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest;

import br.ufg.jatai.fsw.sisquest.model.Professor;
import br.ufg.jatai.fsw.sisquest.model.Usuario;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;

/**
 *
 * @author dfranco
 */
@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "session")
@SessionScope
public class SessaoUsuario {

    @Autowired
    private HttpSession httpSession;

    private String nomeUsuario;
    private String tipoUsuario;
    private String emailUsuario;

    public void entrar(Usuario usuarioLogado) {
        organizaObjetos(usuarioLogado);
    }

    public void sair() {
        organizaObjetos(null);
    }

    private void organizaObjetos(Usuario u) {
        if (u == null) {
            httpSession.removeAttribute("usuarioLogado");
            nomeUsuario = null;
            tipoUsuario = null;
            emailUsuario = null;

        } else {
            httpSession.setAttribute("usuarioLogado", u);
            setNomeUsuario();
            setTipoUsuario();
            setEmailUsuario();
        }
    }

    private Usuario getUsuario() {
        return (Usuario) httpSession.getAttribute("usuarioLogado");
    }

    private void setTipoUsuario() {
        tipoUsuario = getUsuario().getTipoUsuario().toString();
    }

    private void setNomeUsuario() {
        if (getUsuario().getTipoUsuario().equals(Usuario.TipoUsuario.PROFESSOR)) {
            nomeUsuario = getUsuario().getProfessor().getNome();
        } else {
            nomeUsuario = "";
        }
    }

    private void setEmailUsuario() {
        if (getUsuario().getTipoUsuario().equals(Usuario.TipoUsuario.PROFESSOR)) {
            emailUsuario = getUsuario().getProfessor().getEmail();
        } else {
            emailUsuario = "";
        }
    }

    @Override
    public String toString() {
        return "SessaoUsuario{" + "nomeUsuario=" + nomeUsuario + ", tiopUsuario=" + tipoUsuario + '}';
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public Professor getProfessor() {
        return getUsuario().getProfessor();
    }

}
