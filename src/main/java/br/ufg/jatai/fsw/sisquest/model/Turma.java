/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.sisquest.model;

import java.util.List;

/**
 *
 * @author dfranco
 */
public class Turma {

    private Integer id;
    private String nome;
    private String descricao;
    private List<Tarefa> tarefas;
    private List<Team> teams;
}
