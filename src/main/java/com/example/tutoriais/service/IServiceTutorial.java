package com.example.tutoriais.service;

import com.example.tutoriais.model.Tutorial;

import java.util.List;

public interface IServiceTutorial {
    Tutorial save(Tutorial tutorial);
    Tutorial update(Tutorial tutorial);
    Tutorial findById(long id);
    List<Tutorial> findAllPublished(String situation);
    List<Tutorial> findByTitle(String title);
    List<Tutorial> find();
    void delete(long id);
    void deleteAll();
}
