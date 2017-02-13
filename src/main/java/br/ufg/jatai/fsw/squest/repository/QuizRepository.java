package br.ufg.jatai.fsw.squest.repository;

import br.ufg.jatai.fsw.squest.domain.quis.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dyeimys on 22/01/17.
 */
@Repository
public interface QuizRepository extends JpaRepository<Quiz,Integer>{

    public List<Quiz> findAllByTarefa_Id(Integer id);


}
