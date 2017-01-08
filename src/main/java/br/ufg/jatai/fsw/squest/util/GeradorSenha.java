package br.ufg.jatai.fsw.squest.util;

import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

/**
 * Created by thevilela on 08/01/17.
 */
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


}
