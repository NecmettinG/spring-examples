package com.springtutorial.controller;


import com.springtutorial.Service.PersonService;
import com.springtutorial.entity.Person;
import com.springtutorial.repo.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personrepo;

    @Autowired
    private PersonService personService;

    @PostMapping("/savePerson")
    public ResponseEntity<String> save(@RequestBody List<Person> persondata){
        personrepo.saveAll(persondata);
        return ResponseEntity.ok("Success");
    }

    @DeleteMapping("/deletePerson")
    public ResponseEntity<String> delete(@RequestBody Long primary_id){

        return ResponseEntity.ok(personService.deletePerson(primary_id));
    }

    @GetMapping("/getPerson")
    public List<Person> getPerson(){

        return personrepo.findAll();
    }
}
