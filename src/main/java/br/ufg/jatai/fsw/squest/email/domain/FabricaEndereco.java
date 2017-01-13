package br.ufg.jatai.fsw.squest.email.domain;

import br.ufg.jatai.fsw.squest.domain.Aluno;
import br.ufg.jatai.fsw.squest.domain.Equipe;

import java.util.Iterator;
import java.util.List;

/**
 * Created by thevilela on 13/01/17.
 */
public class FabricaEndereco {

    public EnderecoEletronico criaEndereco(Aluno aluno){

        EnderecoEletronico endereco = new EnderecoEletronico();

        endereco.setNome(aluno.getNome());
        endereco.setEmail(aluno.getEmail());

        return endereco;

    }

    public List<EnderecoEletronico> criaEndereco(Equipe equipe){

        Iterator<Aluno> i = equipe.getAlunos().iterator();

        List<EnderecoEletronico> enderecos = null;

        while (i.hasNext()){

            Aluno a = i.next();
            EnderecoEletronico e = new EnderecoEletronico();

            e.setNome(a.getNome());
            e.setEmail(a.getEmail());

            enderecos.add(e);

        }

        return enderecos;

    }

}
