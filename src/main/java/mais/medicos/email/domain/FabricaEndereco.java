package mais.medicos.email.domain;


import mais.medicos.domain.Medico;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by thevilela on 13/01/17.
 */

@Component
public class FabricaEndereco {



    public EnderecoEletronico criaEndereco(Medico medico){

        EnderecoEletronico endereco = new EnderecoEletronico();

        endereco.setNome(medico.getNome());
        endereco.setEmail(medico.getEmail());

        return endereco;

    }



}
