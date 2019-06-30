package com.deepakshankar.posts.service;

import com.deepakshankar.posts.model.Author;
import com.deepakshankar.posts.repository.AuthorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private AuthorDAO repo;

    public AuthorService() {
    }

    @Autowired
    public AuthorService(AuthorDAO repo) {
        this.repo = repo;
    }

    public List<Author> findAll(){
        return repo.findAll();
    }

    public Author findOne(final Long id) {
        return this.repo.getOne(id);
    }

    public Author saveOne(final Author author){
        return repo.saveAndFlush(author);
    }
}
