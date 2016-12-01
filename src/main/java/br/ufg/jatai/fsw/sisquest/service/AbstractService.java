/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.service;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author dfranco
 * @param <T> Genérico
 * @param <ID> Id
 */
public interface AbstractService<T extends Object, ID extends Serializable> {

    /**
     * 
     * @param entidade
     * @return
     */
    public T inserir(T entidade);

    /**
     *
     * @param entidade
     */
    public void apagar(T entidade);

    /**
     *
     * @param entidade
     * @return
     */
    public T atualizar(T entidade);

    /**
     *
     * @param entidade
     * @return
     */
    public T find(T entidade);

    /**
     *
     * @param id
     * @return
     */
    public T find(ID id);

    /**
     *
     * @return
     */
    public List<T> findAll();

}
