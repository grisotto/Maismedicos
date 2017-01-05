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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
    @Column(unique = true)
    private String login;
    private String senha;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @OneToOne(mappedBy = "usuario")
    private Professor professor;

    public Usuario() {
    }

    public Usuario(Integer id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(Usuario u) {
        setId(u.getId());
        setLogin(u.getLogin());
        setProfessor(u.getProfessor());
        setSenha(u.getSenha());
        setTipoUsuario(u.getTipoUsuario());
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

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

    public enum TipoUsuario implements GrantedAuthority {
        PROFESSOR {
            @Override
            public String getAuthority() {
                return "PROFESSOR";
            }
        }, GRUPO {
            @Override
            public String getAuthority() {
                return "GRUPO";
            }
        }, ALUNO {
            @Override
            public String getAuthority() {
                return "ALUNO";
            }
        }, ADMIN {
            @Override
            public String getAuthority() {
                return "ADMIN";
            }
        };

        @Override
        public abstract String getAuthority();
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Professor getProfessor() {
        return professor;
    }

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
}
