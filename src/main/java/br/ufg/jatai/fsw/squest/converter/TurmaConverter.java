package br.ufg.jatai.fsw.squest.converter;

import br.ufg.jatai.fsw.squest.controller.ProfessorController;
import br.ufg.jatai.fsw.squest.domain.Turma;
import br.ufg.jatai.fsw.squest.repository.TurmaRepository;
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
public class TurmaConverter implements Converter<Integer, Turma> {

    private static Logger log = LoggerFactory.getLogger(TurmaConverter.class.getName());

    @Autowired
    private TurmaRepository turmaRepository;

    @Override
    public Turma convert(Integer integer) {
        log.info("Converter: "+TurmaConverter.class);
        return turmaRepository.findOne(integer);
    }
}
