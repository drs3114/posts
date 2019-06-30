package com.deepakshankar.posts.service;

import com.deepakshankar.posts.model.Paragraph;
import com.deepakshankar.posts.repository.ParagraphDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParagraphService {

    private ParagraphDAO repo;

    public ParagraphService() {
    }

    @Autowired
    public ParagraphService(ParagraphDAO repo) {
        this.repo = repo;
    }

    public List<Paragraph> findAll() {
        return repo.findAll();
    }

    public Paragraph saveOne(final Paragraph paragraph) {
        return repo.saveAndFlush(paragraph);
    }
}
