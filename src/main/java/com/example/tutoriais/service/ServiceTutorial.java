package com.example.tutoriais.service;

import com.example.tutoriais.model.Tutorial;
import com.example.tutoriais.repository.ITutorialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTutorial implements IServiceTutorial{

    @Autowired
    private ITutorialRepo repo;

    @Override
    public Tutorial save(Tutorial tutorial) {
        return repo.save(tutorial);
    }

    @Override
    public Tutorial update(Tutorial tutorial) {
        this.findById(tutorial.getId());
        return repo.save(tutorial);
    }

    @Override
    public Tutorial findById(long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Tutorial> findAllPublished(String situation) {
        return repo.findBySituation(situation);
    }

    @Override
    public List<Tutorial> findByTitle(String title) {
        return repo.findByTitleLike(title);
    }

    @Override
    public List<Tutorial> find(){
        return (List<Tutorial>) repo.findAll();
    }

    @Override
    public void delete(long id) {
        findById(id);
        repo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repo.deleteAll();
    }
}
