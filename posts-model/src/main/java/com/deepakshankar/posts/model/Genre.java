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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * This is an entity class that defines what
 * genre a post should be associated with
 *
 * @author deepak
 * @version 1.0
 */
@Entity
@Table(name = "GENRE")
public class Genre {

    private Long id;
    private String name;
    private String description;

    /**
     * This is a default constructor
     */
    public Genre() {
        this(null);
    }

    /**
     * Construct a genre
     *
     * @param name the name of the genre
     */
    public Genre(String name) {
        this(null, name);
    }

    /**
     * Construct a genre
     *
     * @param id   the id of the genre
     * @param name the name of the genre
     */
    public Genre(Long id, String name) {
        this(id, name, null);
    }

    /**
     * Construct a genre
     *
     * @param id          the id of the genre
     * @param name        the name of the genre
     * @param description the description of the genre
     */
    public Genre(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     * Get the id of the genre
     *
     * @return the id of the genre
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GNR_ID")
    public Long getId() {
        return id;
    }

    /**
     * Set the id of the genre
     *
     * @param id the id of the genre
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the name of the genre
     *
     * @return the name of the genre
     */
    @NotNull
    @Column(name = "GNR_NME")
    public String getName() {
        return name;
    }

    /**
     * Set the name of the genre
     *
     * @param name the name of hte genre
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the description of the genre
     *
     * @return the description of the genre
     */
    @Column(name = "GNR_DESC")
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the genre
     *
     * @param description the description of the genre
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
