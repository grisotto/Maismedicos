/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.service;

import java.util.List;

/**
 *
 * @author dfranco
 * @param <T> Genérico
 */
public interface AbrastractService<T> {

    public T inserir(T entidade);

    public void apagar(T entidade);

    public T atualizar(T entidade);

    public T find(T entidade);

    public List<T> findAll();

}
