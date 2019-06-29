package com.deepakshankar.posts.service;

import com.deepakshankar.posts.model.Post;
import com.deepakshankar.posts.repository.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostDao repo;

    @Autowired
    public PostService(PostDao repo) {
        this.repo = repo;
    }

    public List<Post> findAll(){
        return repo.findAll();
    }

    public Post saveOne(final Post post) {
        return repo.saveAndFlush(post);
    }
}
