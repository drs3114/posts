package com.deepakshankar.posts.service;

import com.deepakshankar.posts.model.Post;
import com.deepakshankar.posts.repository.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    private PostDAO repo;

    public PostService() {
    }

    @Autowired
    public PostService(PostDAO repo) {
        this.repo = repo;
    }

    @Transactional
    public List<Post> findAll(){
        return repo.findAll();
    }

    @Transactional
    public Post saveOne(final Post post) {
        return repo.saveAndFlush(post);
    }
}
