package com.deepakshankar.posts.controller;

import com.deepakshankar.posts.model.Post;
import com.deepakshankar.posts.model.Reaction;
import com.deepakshankar.posts.service.AuthorService;
import com.deepakshankar.posts.service.ParagraphService;
import com.deepakshankar.posts.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
@CrossOrigin()
public class PostController {

    private PostService service;

    @Autowired
    public PostController(PostService service ) {
        this.service = service;
    }

    @GetMapping
    public List<Post> findAll(){
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public Post findOne(@PathVariable(value = "id") final long id) {
        return service.findOne(id);
    }
    @PostMapping
    public Post saveOne(@RequestBody final Post post){
        return service.saveOne(post);
    }

    @PostMapping("{id}")
    public Post react(@PathVariable(value = "id") final long id, @RequestBody final Reaction reaction) {
        return this.service.react(id, reaction);
    }
}
