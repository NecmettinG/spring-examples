package com.springtutorial.Service;

import com.springtutorial.entity.Notes;
import com.springtutorial.entity.Person;
import com.springtutorial.repo.NotesRepository;
import com.springtutorial.repo.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepo_personService;


    public String deletePerson (Long primary_id){

        Person deletedPerson = personRepo_personService.findById(primary_id)
                .orElseThrow(() -> new EntityNotFoundException("Person not found with id " +primary_id));

        deletedPerson.setStatus(false);


        for (Notes note: deletedPerson.getNotes()){
            note.setStatus(false);
        }

        personRepo_personService.save(deletedPerson);

        return "deleted successfully";
    }
}
