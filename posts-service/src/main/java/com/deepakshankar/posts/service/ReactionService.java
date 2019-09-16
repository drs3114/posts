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
import com.deepakshankar.posts.model.Reaction;
import com.deepakshankar.posts.repository.ReactionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReactionService {

    private ReactionDAO repo;

    @Autowired
    public ReactionService(ReactionDAO repo) {
        this.repo = repo;
    }

    public Reaction findOne(final Long id) {
        return this.repo.findById(id).orElseThrow(EntityNotFound::new);
    }

    public Reaction saveOne(final Reaction reaction) {
        return this.repo.saveAndFlush(reaction);
    }
}
