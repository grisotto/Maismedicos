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


}