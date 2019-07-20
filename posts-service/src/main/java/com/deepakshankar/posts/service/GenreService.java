package com.deepakshankar.posts.service;

import com.deepakshankar.posts.model.Genre;
import com.deepakshankar.posts.repository.GenreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private GenreDAO repo;

    public GenreService() {
    }

    @Autowired
    public GenreService(GenreDAO repo) {
        this.repo = repo;
    }

    public Genre findOne(final Long id) {
        return repo.getOne(id);
    }

    public List<Genre> findAll() {
        return repo.findAll();
    }

    public Genre saveOne(final Genre genre) {
        return repo.saveAndFlush(genre);
    }
}
