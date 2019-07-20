package com.deepakshankar.posts.service;

import com.deepakshankar.posts.exception.EntityNotFound;
import com.deepakshankar.posts.model.Reaction;
import com.deepakshankar.posts.repository.ReactionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReactionService {

    private ReactionDAO repo;

    @Autowired
    public ReactionService(ReactionDAO repo) {
        this.repo = repo;
    }

    public Reaction findOne(final Long id) {
        return this.repo.findById(id).orElseThrow(EntityNotFound::new);
    }

    public Reaction saveOne(final Reaction reaction) {
        return this.repo.saveAndFlush(reaction);
    }
}
