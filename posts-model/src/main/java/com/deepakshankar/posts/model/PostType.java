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

/**
 * An enumeration that defines what type a post is
 */
public enum PostType {
    /**
     * Represents a blog post type
     */
    BLOG(0, "BLOG", "A blog post"),
    /**
     * Represents a poem post type
     */
    POEM(1, "POEM", "A poem post");
    public int id;
    public String name;
    public String description;

    /**
     * Construct a new post type
     *
     * @param id          the id of the post type
     * @param name        the name of the post type
     * @param description the description of the post type
     */
    PostType(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     * Get the id of the post type
     *
     * @return the id of the post type
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id of the post type
     *
     * @param id the id of the post type
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the name of the post type
     *
     * @return the name of the post type
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the post type
     *
     * @param name the name of the post type
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the description of the post type
     *
     * @return the description of the post type
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the post type
     *
     * @param description the description of the post type
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the post type from the id
     *
     * @param id the id of the post type
     * @return the post type that matches the id.
     * Throws an IllegalArgumentException if the id does not matches
     */
    public PostType getType(final int id) {
        return Arrays.stream(PostType.values())
                .filter(postType -> id == postType.getId())
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    /**
     * Get the post type from the name
     *
     * @param name the name of the post type
     * @return the post type that matches the name.
     * Throws an IllegalArgumentException if the name does not match
     */
    public PostType getType(final String name) {
        return Arrays.stream(PostType.values())
                .filter(postType -> name.equalsIgnoreCase(postType.getName()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
