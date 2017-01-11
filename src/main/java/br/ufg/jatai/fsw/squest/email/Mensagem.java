package br.ufg.jatai.fsw.squest.email;

/**
 * @author vilela
 */

public class Mensagem {

    private String destinatario;
    private String assunto;
    private String corpo;

    public Mensagem(){

    }

    public Mensagem(String destinatario, String assunto, String corpo) {
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.corpo = corpo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mensagem mensagem = (Mensagem) o;

        if (destinatario != null ? !destinatario.equals(mensagem.destinatario) : mensagem.destinatario != null)
            return false;
        if (assunto != null ? !assunto.equals(mensagem.assunto) : mensagem.assunto != null) return false;
        return corpo != null ? corpo.equals(mensagem.corpo) : mensagem.corpo == null;

    }

    @Override
    public int hashCode() {
        int result = destinatario != null ? destinatario.hashCode() : 0;
        result = 31 * result + (assunto != null ? assunto.hashCode() : 0);
        result = 31 * result + (corpo != null ? corpo.hashCode() : 0);
        return result;
    }
}