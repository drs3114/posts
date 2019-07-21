package com.deepakshankar.posts.service;

import com.deepakshankar.posts.exception.EntityNotFound;
import com.deepakshankar.posts.model.Author;
import com.deepakshankar.posts.model.Post;
import com.deepakshankar.posts.repository.AuthorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorService {

    private AuthorDAO repo;
    private PostService postService;
    private ParagraphService paragraphService;

    public AuthorService() {
    }

    @Autowired
    public AuthorService(AuthorDAO repo, PostService postService, ParagraphService paragraphService) {
        this.repo = repo;
        this.postService = postService;
        this.paragraphService = paragraphService;
    }

    public List<Author> findAll(){
        return repo.findAll();
    }

    @Transactional
    public Author findOne(final Long id) {
        return this.repo
                .findById(id)
                .orElseThrow(EntityNotFound::new);
    }

    @Transactional
    public Author saveOne(Author author){
        return repo.save(author);
    }

    @Transactional
    public Author createNewPost(final Long id, final Post post) {
        Author author = findOne(id);
        return createNewPost(author, post);
    }

    @Transactional
    public Author createNewPost(final Author author, final Post post) {

        post.getParagraphs().forEach(paragraph -> paragraphService.saveOne(paragraph));
        final Post savedPost = postService.saveOne(post);
        author.getPosts().add(savedPost);
        return this.repo.save(author);
    }
}
