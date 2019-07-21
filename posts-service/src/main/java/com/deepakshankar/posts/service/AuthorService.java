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
