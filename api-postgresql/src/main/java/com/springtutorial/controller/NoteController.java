package com.springtutorial.controller;

import com.springtutorial.entity.Notes;
import com.springtutorial.repo.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoteController {

    @Autowired
    private NotesRepository noterepo;

    @GetMapping("/getNote")
    public List<Notes> getNotes(){

        return noterepo.findAll();
    }
}
