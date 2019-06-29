package com.deepakshankar.posts.service;

import com.deepakshankar.posts.model.Author;
import com.deepakshankar.posts.repository.AuthorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private AuthorDao repo;

    @Autowired
    public AuthorService(AuthorDao repo) {
        this.repo = repo;
    }

    public List<Author> findAll(){
        return repo.findAll();
    }

    public Author saveOne(final Author author){
        return repo.saveAndFlush(author);
    }
}
