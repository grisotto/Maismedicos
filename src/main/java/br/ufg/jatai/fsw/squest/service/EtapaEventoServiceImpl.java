/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.service;

import br.ufg.jatai.fsw.squest.domain.EtapaEvento;
import br.ufg.jatai.fsw.squest.repository.EtapaEventoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtapaEventoServiceImpl implements EtapaEventoService {

    @Autowired
    private EtapaEventoRepository eeRepository;

    @Override
    public EtapaEvento inserir(EtapaEvento entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apagar(EtapaEvento entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EtapaEvento atualizar(EtapaEvento entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EtapaEvento find(EtapaEvento entidade) {
        return eeRepository.findOne(entidade.getId());
    }

    @Override
    public EtapaEvento find(Integer id) {
        return eeRepository.findOne(id);

    }

    @Override
    public List<EtapaEvento> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
