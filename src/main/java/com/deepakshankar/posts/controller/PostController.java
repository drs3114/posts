package com.deepakshankar.posts.controller;

import com.deepakshankar.posts.model.Post;
import com.deepakshankar.posts.service.AuthorService;
import com.deepakshankar.posts.service.ParagraphService;
import com.deepakshankar.posts.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/posts")
@CrossOrigin()
public class PostController {

    private PostService service;
    private AuthorService authorService;
    private ParagraphService paragraphService;

    @Autowired
    public PostController(PostService service, AuthorService authorService, ParagraphService paragraphService) {
        this.service = service;
        this.authorService = authorService;
        this.paragraphService = paragraphService;
    }

    @GetMapping(value = "/")
    public List<Post> findAll(){
        return this.service.findAll();
    }

    @PostMapping(value = "/")
    public Post saveOne(@RequestBody final Post post){
        authorService.saveOne(post.getAuthor());
        post.getParagraphs().forEach(paragraph -> paragraphService.saveOne(paragraph));
        return service.saveOne(post);
    }
}
