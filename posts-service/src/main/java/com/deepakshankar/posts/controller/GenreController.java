package com.deepakshankar.posts.controller;

import com.deepakshankar.posts.model.Genre;
import com.deepakshankar.posts.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/genre")
@CrossOrigin
public class GenreController {

    private GenreService service;

    @Autowired
    public GenreController(GenreService service) {
        this.service = service;
    }

    @GetMapping
    public List<Genre> findAll() {
        return this.service.findAll();
    }

    @PostMapping
    public Genre saveOne(@RequestBody final Genre genre) {
        return this.service.saveOne(genre);
    }
}
