/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mais.medicos.domain;

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

     @OneToOne(mappedBy = "usuario")
    private Medico medico;

    @OneToOne(mappedBy = "usuario")
    private Paciente paciente;

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
     * @param uu
     */
    public Usuario(Usuario uu) {
        setId(uu.getId());
        setLogin(uu.getLogin());
        setSenha(uu.getSenha());
        setTipoUsuario(uu.getTipoUsuario());
    }

//    /**
//     *
//     * @param u
//     */
//    public Usuario(Usuario u) {
//        setId(u.getId());
//        setLogin(u.getLogin());
//        setMedico(u.getMedico());
//        setSenha(u.getSenha());
//        setTipoUsuario(u.getTipoUsuario());
//    }

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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     *
     */
    public enum TipoUsuario implements GrantedAuthority {

        /**
         *
         */
        PACIENTE {
            @Override
            public String getAuthority() {
                return "PACIENTE";
            }
        },
        MEDICO {
            @Override
            public String getAuthority() {
                return "MEDICO";
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


    public Medico getMedico() {
        return medico;
    }



    public void setMedico(Medico medico) {
        this.medico = medico;
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
