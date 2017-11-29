/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mais.medicos.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table
@SuppressWarnings("PersistenceUnitPresent")
public class Medico extends Pessoa {

    @Email
    @NotBlank
    @NotNull
    @Column(unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    @OneToMany(mappedBy = "Medico")
    private List<Turma> turmas;

    /**
     *
     * @param email
     * @param usuario
     */
    public Medico(String email, Usuario usuario) {
        this.email = email;
        this.usuario = usuario;
    }

    /**
     *
     */
    public Medico() {
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     *
     * @param usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.email);
        hash = 43 * hash + Objects.hashCode(this.usuario);
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
        final Medico other = (Medico) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    public List<Turma> getTurmas() {
        return turmas;
    }

    /**
     *
     * @param turmas
     */
    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "email='" + email + '\'' +
                ", usuario.login=" + usuario.getLogin() +
                ", turmas=" + turmas +
                '}';
    }
}