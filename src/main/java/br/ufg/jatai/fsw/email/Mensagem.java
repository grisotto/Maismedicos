package br.ufg.jatai.fsw.email;

import java.io.File;
import java.util.List;

/**
 *
 * @author vilela
 */
public class Mensagem {

    private List<String> destinatarios;
    private List<String> bcc;
    private List<File> anexos;

    private String assunto;
    private String corpo;

    public Mensagem(List<String> destinatarios, String assunto, String corpo) {
        this.destinatarios = destinatarios;
        this.assunto = assunto;
        this.corpo = corpo;
    }

    public Mensagem(List<String> destinatarios, List<String> bcc, String assunto, String corpo) {
        this.destinatarios = destinatarios;
        this.bcc = bcc;
        this.assunto = assunto;
        this.corpo = corpo;
    }

    public Mensagem(List<String> destinatarios, List<String> bcc, List<File> anexos, String assunto, String corpo) {
        this.destinatarios = destinatarios;
        this.bcc = bcc;
        this.anexos = anexos;
        this.assunto = assunto;
        this.corpo = corpo;
    }

    public List<String> getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(List<String> destinatarioss) {
        this.destinatarios = destinatarioss;
    }

    public List<String> getBcc() {
        return bcc;
    }

    public void setBcc(List<String> bcc) {
        this.bcc = bcc;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public List<File> getAnexos() {
        return anexos;
    }

    public void setAnexos(List<File> anexos) {
        this.anexos = anexos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mensagem mensagem = (Mensagem) o;

        if (destinatarios != null ? !destinatarios.equals(mensagem.destinatarios) : mensagem.destinatarios != null)
            return false;
        if (bcc != null ? !bcc.equals(mensagem.bcc) : mensagem.bcc != null) return false;
        if (anexos != null ? !anexos.equals(mensagem.anexos) : mensagem.anexos != null) return false;
        if (assunto != null ? !assunto.equals(mensagem.assunto) : mensagem.assunto != null) return false;
        return corpo != null ? corpo.equals(mensagem.corpo) : mensagem.corpo == null;

    }

    @Override
    public int hashCode() {
        int result = destinatarios != null ? destinatarios.hashCode() : 0;
        result = 31 * result + (bcc != null ? bcc.hashCode() : 0);
        result = 31 * result + (anexos != null ? anexos.hashCode() : 0);
        result = 31 * result + (assunto != null ? assunto.hashCode() : 0);
        result = 31 * result + (corpo != null ? corpo.hashCode() : 0);
        return result;
    }

}
