package br.ufg.jatai.fsw.squest.email.domain;
import java.io.File;
import java.util.List;

/**
 *
 * @author vilela
 */
public class Mensagem {

    private List<EnderecoEletronico> destinatarios;
    private List<EnderecoEletronico> bcc;
    private List<EnderecoEletronico> cc;
    private List<File> anexos;

    private String assunto;
    private String corpo;

    public Mensagem(){

    }

    public List<EnderecoEletronico> getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(List<EnderecoEletronico> destinatarios) {
        this.destinatarios = destinatarios;
    }

    public List<EnderecoEletronico> getBcc() {
        return bcc;
    }

    public void setBcc(List<EnderecoEletronico> bcc) {
        this.bcc = bcc;
    }

    public List<EnderecoEletronico> getCc() {
        return cc;
    }

    public void setCc(List<EnderecoEletronico> cc) {
        this.cc = cc;
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

        if (!destinatarios.equals(mensagem.destinatarios)) return false;
        if (!bcc.equals(mensagem.bcc)) return false;
        if (!cc.equals(mensagem.cc)) return false;
        if (anexos != null ? !anexos.equals(mensagem.anexos) : mensagem.anexos != null) return false;
        if (!assunto.equals(mensagem.assunto)) return false;
        return corpo.equals(mensagem.corpo);
    }

    @Override
    public int hashCode() {
        int result = destinatarios.hashCode();
        result = 31 * result + bcc.hashCode();
        result = 31 * result + cc.hashCode();
        result = 31 * result + (anexos != null ? anexos.hashCode() : 0);
        result = 31 * result + assunto.hashCode();
        result = 31 * result + corpo.hashCode();
        return result;
    }
}