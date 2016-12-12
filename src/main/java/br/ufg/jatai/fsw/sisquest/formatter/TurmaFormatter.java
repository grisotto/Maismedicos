/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.formatter;

import br.ufg.jatai.fsw.sisquest.model.Turma;
import br.ufg.jatai.fsw.sisquest.service.TurmaService;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

/**
 *
 * @author dfranco
 */
@Service
public class TurmaFormatter implements Formatter<Turma> {

    public TurmaService turmaService;

    @Override
    public String print(Turma t, Locale locale) {
        return t.getNome();
    }

    @Override
    public Turma parse(String string, Locale locale) throws ParseException {
        return turmaService.find(Integer.parseInt(string));

    }

}
