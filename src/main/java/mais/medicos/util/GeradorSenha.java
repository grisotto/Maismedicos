package br.ufg.jatai.fsw.squest.util;

import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * Created by thevilela on 08/01/17.
 */
@Component
public class GeradorSenha {

    @Value("${gerador.password}")
    private boolean ativo;

    public GeradorSenha() {
    }

    public GeradorSenha(boolean ativo){
        this.ativo = ativo;
    }

    public String gerarSenha(){

        if(ativo){

            UUID uuid = UUID.randomUUID();
            String myRandom = uuid.toString();

            return myRandom.substring(0,6);

        }

        return "123";
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }


}
