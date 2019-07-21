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

package com.deepakshankar.posts.model;

import java.util.Arrays;

public enum PostType {
    BLOG(0, "BLOG", "A blog post"),
    POEM(1, "POEM", "A poem post");
    public int id;
    public String name;
    public String description;

    PostType(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PostType getType(final int id) {
        return Arrays.stream(PostType.values())
                .filter(postType -> id == postType.getId())
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public PostType getType(final String name) {
        return Arrays.stream(PostType.values())
                .filter(postType -> name.equalsIgnoreCase(postType.getName()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
