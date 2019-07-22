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

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * This is an entity class that that holds the information about the authors
 *
 * @author deepak
 * @version 1.0
 */
@Entity
@Table(name = "ATHR")
@DynamicUpdate
public class Author {
    private Long id;
    private String firstName;
    private String lastName;
    private String penName;
    private String email;
    private Set<String> websites;
    private Set<Post> posts;

    /**
     * This is the default constructor
     */
    public Author() {
        this(null, null);
    }

    /**
     * Construct an author with first name and last name
     *
     * @param firstName the first name of the author
     * @param lastName  the last name of the author
     */
    public Author(String firstName, String lastName) {
        this(null, firstName, lastName, null);
    }

    /**
     * Construct an author with first name, last name and email
     *
     * @param firstName the first name of the author
     * @param lastName  the last name of the author
     * @param email     the email of the author
     */
    public Author(String firstName, String lastName, String email) {
        this(null, firstName, lastName, null, email, null);
    }

    /**
     * Construct an author with first name, last name and the authors pen name
     *
     * @param id        the id of the author
     * @param firstName the first name of the author
     * @param lastName  the last name of the author
     * @param penName   the pen name of the author
     */
    public Author(Long id, String firstName, String lastName, String penName) {
        this(id, firstName, lastName, penName, null);
    }

    /**
     * Construct an author with basic author information and associate their posts
     *
     * @param id        the id of the author
     * @param firstName the first name of the author
     * @param lastName  the last name of the author
     * @param penName   the pen name of the author
     * @param posts     the posts of the author
     */
    public Author(Long id, String firstName, String lastName, String penName, Set<Post> posts) {
        this(id, firstName, lastName, penName, null, posts);
    }

    /**
     * Construct an author object
     *
     * @param id        the id of the author
     * @param firstName the first name of the author
     * @param lastName  the last name of the author
     * @param penName   the pen name of the author
     * @param email     the email of the author
     * @param posts     the posts written by the author
     */
    public Author(Long id, String firstName, String lastName, String penName, String email, Set<Post> posts) {
        this(id, firstName, lastName, penName, email, null, posts);
    }

    /**
     * Construct an author object
     *
     * @param id        the id of the author
     * @param firstName the first name of the author
     * @param lastName  the last name of the author
     * @param penName   the pen name of the author
     * @param email     the email of the author
     * @param websites  the websites of the author
     * @param posts     the posts written by the author
     */
    public Author(Long id, String firstName, String lastName, String penName, String email, Set<String> websites, Set<Post> posts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.penName = penName;
        this.email = email;
        this.websites = websites;
        this.posts = posts;
    }

    /**
     * Get the id of the author
     *
     * @return the id of the author
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ATR_ID")
    public Long getId() {
        return id;
    }

    /**
     * Set the if of the author
     *
     * @param id of the author
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the first name of the author
     *
     * @return the first name of the author
     */
    @NotNull
    @Column(name = "ATR_FRST_NM", length = 25)
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of the author
     *
     * @param firstName the first name of the author
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the last name of the author
     *
     * @return the last name of the author
     */
    @NotNull
    @Column(name = "ATR_LST_NM", length = 25)
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name of the author
     *
     * @param lastName the last name of the author
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the pen name of the author
     *
     * @return the pen name of the author
     */
    @Column(name = "ATR_PEN_NM", length = 15)
    public String getPenName() {
        return penName;
    }

    /**
     * Set the pen name of the author
     *
     * @param penName the pen name of the author
     */
    public void setPenName(String penName) {
        this.penName = penName;
    }

    /**
     * Get the email of the author
     *
     * @return the email of the author
     */
    @NotNull
    @Column(name = "ATR_EML", unique = true)
    public String getEmail() {
        return email;
    }

    /**
     * Set the email of the author
     *
     * @param email the email of the author
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the websites of the author
     *
     * @return the websites of the author
     */
    @ElementCollection
    public Set<String> getWebsites() {
        return websites;
    }

    /**
     * Set the websites of the author
     *
     * @param websites the websites of the author
     */
    public void setWebsites(Set<String> websites) {
        this.websites = websites;
    }

    /**
     * Get the posts written by the author
     *
     * @return the posts written by the author
     */
    @ManyToMany
    @JoinColumn(name = "ATR_PSTS")
    public Set<Post> getPosts() {
        return posts;
    }

    /**
     * Set the posts for an author
     *
     * @param posts the posts of the author
     */
    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}