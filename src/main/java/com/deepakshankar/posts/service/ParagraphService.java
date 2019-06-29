package com.deepakshankar.posts.service;

import com.deepakshankar.posts.model.Paragraph;
import com.deepakshankar.posts.repository.ParagraphDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParagraphService {

    private ParagraphDao repo;

    @Autowired
    public ParagraphService(ParagraphDao repo) {
        this.repo = repo;
    }

    public List<Paragraph> findAll() {
        return repo.findAll();
    }

    public Paragraph saveOne(final Paragraph paragraph) {
        return repo.saveAndFlush(paragraph);
    }
}
