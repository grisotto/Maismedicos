
package mais.medicos.repository;

import mais.medicos.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author dfranco
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    /**
     *
     * @param login
     * @return
     */
    @Query(value = "select u from Usuario u where u.login = ?1")
    public Usuario userForAuth(String login);

}