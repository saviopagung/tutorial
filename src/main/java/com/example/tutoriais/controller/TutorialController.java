package com.example.tutoriais.controller;

import com.example.tutoriais.model.Tutorial;
import com.example.tutoriais.service.IServiceTutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {

    @Autowired
    private IServiceTutorial service;

    @PostMapping
    public ResponseEntity<Tutorial> create(@RequestBody Tutorial tutorial){
        return new ResponseEntity<>(service.save(tutorial), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Tutorial>> find(@RequestParam @Nullable String title){
        if (title != null) {
            return new ResponseEntity<>(service.findByTitle(title), HttpStatus.OK);
        }
        return new ResponseEntity<>(service.find(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutorial> findAll(@PathVariable long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Tutorial> update(@RequestBody Tutorial tutorial){
        return new ResponseEntity<>(service.update(tutorial), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tutorial> delete(@PathVariable long id){
        service.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Tutorial> deleteAll(){
        service.deleteAll();
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/published")
    public ResponseEntity<List<Tutorial>> published(){
        return new ResponseEntity<>(service.findAllPublished("published"), HttpStatus.OK);
    }

}
