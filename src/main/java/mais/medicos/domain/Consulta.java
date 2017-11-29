/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mais.medicos.domain;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@SuppressWarnings("PersistenceUnitPresent")
public class Consulta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    private String nome;
    private String descricao;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime data;



//    //    @ElementCollection
//    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<Tarefa> tarefas = new HashSet<>();



    @OneToOne
    private Medico medico;

    @OneToOne
    private Paciente paciente;


    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
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
    public Consulta() {
    }


    public Consulta(Integer id, String descricao, DateTime dataInicial) {
        this.id = id;
        this.descricao = descricao;
        this.data = dataInicial;
    }

    /**
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }




    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }





    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + (this.id != null ? this.id.hashCode() : 0);
//        hash = 17 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 19 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
//        hash = 17 * hash + (this.tarefas != null ? this.tarefas.hashCode() : 0);
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
        final Consulta other = (Consulta) obj;
//        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
//            return false;
//        }
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }

     
        return true;
    }


    @Override
    public String toString() {
        return "consulta{" +
                "id=" + id +
               ", descricao='" + descricao + '\'' +
                '}';
    }

    public DateTime getData() {
        return data;
    }

    public void setData(DateTime data) {
        this.data = data;
    }
}
