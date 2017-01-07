package br.ufg.jatai.fsw.squest.converter;

import br.ufg.jatai.fsw.squest.domain.Tarefa;
import br.ufg.jatai.fsw.squest.repository.TarefaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by dyeimys on 06/01/17.
 * @author dyeimys
 */
@Component
public class TarefaConverter implements Converter<Integer, Tarefa> {

    private static Logger log = LoggerFactory.getLogger(TarefaConverter.class.getName());

    @Autowired
    private TarefaRepository tarefaRepository;

    @Override
    public Tarefa convert(Integer integer) {
        log.info("Converter: "+TarefaConverter.class);
        return tarefaRepository.findOne(integer);
    }
}
