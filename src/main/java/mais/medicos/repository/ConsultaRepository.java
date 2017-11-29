/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mais.medicos.repository;

import mais.medicos.domain.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;


public interface ConsultaRepository extends JpaRepository<Consulta, Integer>, Serializable {


    @Query("select t from Consulta t where t.paciente.id = ?1")
    public List<Consulta> findOfPaciente(Integer paciente_id);

    @Query("select t from Consulta t where t.medico.id = ?1")
    public List<Consulta> findOfMedico(Integer medico_id);



}
