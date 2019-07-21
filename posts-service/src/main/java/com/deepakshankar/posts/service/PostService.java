package com.deepakshankar.posts.service;

import com.deepakshankar.posts.exception.EntityNotFound;
import com.deepakshankar.posts.exception.PostsRuntimeException;
import com.deepakshankar.posts.model.Post;
import com.deepakshankar.posts.model.Reaction;
import com.deepakshankar.posts.repository.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {
    private PostDAO repo;
    private ReactionService reactionService;

    public PostService() {
    }

    @Autowired
    public PostService(PostDAO repo, ReactionService reactionService) {
        this.repo = repo;
        this.reactionService = reactionService;
    }

    @Transactional
    public List<Post> findAll(){
        return repo.findAll();
    }

    @Transactional
    public Post findOne(final long id) {
        return repo.findById(id).orElseThrow(EntityNotFound::new);
    }

    @Transactional(rollbackFor = {PostsRuntimeException.class, IllegalArgumentException.class})
    public Post saveOne(final Post post) {
        return repo.saveAndFlush(post);
    }

    @Transactional
    public Post react(long id, Reaction reaction) {
        final Post post = findOne(id);
        Reaction postReaction = post.getReaction() != null ? post.getReaction() : new Reaction();
        postReaction = reactionService.saveOne(postReaction.update(reaction));
        post.setReaction(postReaction);
        return repo.saveAndFlush(post);
    }
}
