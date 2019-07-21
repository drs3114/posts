/*
 * Copyright (c) 2019. Deepak Ravi Shankar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
