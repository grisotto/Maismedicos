package br.ufg.jatai.fsw.squest.repository;

import br.ufg.jatai.fsw.squest.domain.quis.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dyeimys on 22/01/17.
 */
@Repository
public interface QuizRepository extends JpaRepository<Quiz,Integer>{


}
