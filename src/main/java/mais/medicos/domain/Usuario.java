/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.jatai.fsw.squest.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author dfranco
 */
@Entity
@Table
@SuppressWarnings("PersistenceUnitPresent")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @NotNull
    @Column(unique = true)
    private String login;
    private String senha;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @OneToOne(mappedBy = "usuario",fetch = FetchType.EAGER)
    private Equipe equipe;

    @OneToOne(mappedBy = "usuario")
    private Professor professor;

    /**
     *
     */
    public Usuario() {
    }

    /**
     *
     * @param login
     * @param senha
     * @param tipoUsuario
     */
    public Usuario(String login, String senha, TipoUsuario tipoUsuario) {
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    /**
     *
     * @param id
     * @param login
     * @param senha
     */
    public Usuario(Integer id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

    /**
     *
     * @param u
     */
    public Usuario(Usuario u) {
        setId(u.getId());
        setLogin(u.getLogin());
        setProfessor(u.getProfessor());
        setSenha(u.getSenha());
        setTipoUsuario(u.getTipoUsuario());
    }

    /**
     *
     * @param login
     * @param senha
     */
    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getLogin() {
        return login;
    }

    /**
     *
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     *
     * @return
     */
    public String getSenha() {
        return senha;
    }

    /**
     *
     * @param senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.login);
        hash = 29 * hash + Objects.hashCode(this.senha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     *
     */
    public enum TipoUsuario implements GrantedAuthority {

        /**
         *
         */
        PROFESSOR {
            @Override
            public String getAuthority() {
                return "PROFESSOR";
            }
        },

        /**
         *
         */
        GRUPO {
            @Override
            public String getAuthority() {
                return "GRUPO";
            }
        },

        /**
         *
         */
        ALUNO {
            @Override
            public String getAuthority() {
                return "ALUNO";
            }
        },

        /**
         *
         */
        ADMIN {
            @Override
            public String getAuthority() {
                return "ADMIN";
            }
        };

        /**
         *
         * @return
         */
        @Override
        public abstract String getAuthority();
    }

    /**
     *
     * @return
     */
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     *
     * @param tipoUsuario
     */
    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /**
     *
     * @return
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     *
     * @param professor
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                '}';
    }

    /**
     *
     * @return
     */
    public Equipe getEquipe() {
        return equipe;
    }

    /**
     *
     * @param equipe
     */
    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
