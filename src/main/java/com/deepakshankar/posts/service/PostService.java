package com.deepakshankar.posts.service;

import com.deepakshankar.posts.exception.PostsRuntimeException;
import com.deepakshankar.posts.model.Author;
import com.deepakshankar.posts.model.Post;
import com.deepakshankar.posts.repository.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private PostDAO repo;
    private AuthorService authorService;
    private ParagraphService paragraphService;

    public PostService() {
    }

    @Autowired
    public PostService(PostDAO repo, AuthorService authorService, ParagraphService paragraphService) {
        this.repo = repo;
        this.authorService = authorService;
        this.paragraphService = paragraphService;
    }

    @Transactional
    public List<Post> findAll(){
        return repo.findAll();
    }

    @Transactional
    public Post findOne(final long id) {
        return repo.getOne(id);
    }

    @Transactional(rollbackFor = {PostsRuntimeException.class, IllegalArgumentException.class})
    public Post saveOne(final Post post) {
        Author author = post.getAuthor();
        author = Optional.of(authorService.findOne(author.getId())).orElseThrow(PostsRuntimeException::new);
        post.getParagraphs().forEach(paragraph -> paragraphService.saveOne(paragraph));
        return repo.saveAndFlush(post);
    }
}
