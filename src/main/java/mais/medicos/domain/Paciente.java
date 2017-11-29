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
public class Paciente extends Pessoa {

    @Email
    @NotBlank
    @NotNull
    @Column(unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    @OneToOne
    private Consulta consulta;


    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    /**
     *
     * @param email
     * @param usuario
     */
    public Paciente(String email, Usuario usuario) {
        this.email = email;
        this.usuario = usuario;
    }

    /**
     *
     */
    public Paciente() {
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
        hash = 34 * hash + Objects.hashCode(this.email);
        hash = 34 * hash + Objects.hashCode(this.usuario);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

//    /**
//     *
//     * @return
//     */
//    public List<Turma> getTurmas() {
//        return turmas;
//    }
//
//    /**
//     *
//     * @param turmas
//     */
//    public void setTurmas(List<Turma> turmas) {
//        this.turmas = turmas;
//    }

    @Override
    public String toString() {
        return "Paciente{" +
                "email='" + email + '\'' +
                ", usuario.login=" + usuario.getLogin() +
//                ", turmas=" + turmas +
                '}';
    }
}