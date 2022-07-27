package com.example.tutoriais.repository;

import com.example.tutoriais.model.Tutorial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITutorialRepo extends CrudRepository<Tutorial, Long> {
    List<Tutorial> findBySituation(String situation);
    List<Tutorial> findByTitleLike(String title);

}
