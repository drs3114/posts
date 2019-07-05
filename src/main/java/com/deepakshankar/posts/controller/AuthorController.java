package com.deepakshankar.posts.controller;

import com.deepakshankar.posts.model.Author;
import com.deepakshankar.posts.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/authors")
@CrossOrigin
public class AuthorController {

    private AuthorService service;

    @Autowired
    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Author> findAll() {
        return this.service.findAll();
    }

    @GetMapping(value = "{id}")
    public Author findOne(@PathVariable(name = "id") final Long id) {
        return this.service.findOne(id);
    }

    @PostMapping
    public Author saveOne(@RequestBody final Author author){
        return this.service.saveOne(author);
    }
}
