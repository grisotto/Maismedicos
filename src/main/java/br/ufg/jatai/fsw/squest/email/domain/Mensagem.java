package br.ufg.jatai.fsw.squest.email;
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

    public Mensagem(){

    }

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


}