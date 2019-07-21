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
import org.springframework.lang.Nullable;

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

    public Author() {
        this(null, null);
    }

    public Author(String firstName, String lastName) {
        this(null, firstName, lastName, null);
    }

    public Author(String firstName, String lastName, String email) {
        this(null, firstName, lastName, null, email, null);
    }

    public Author(Long id, String firstName, String lastName, String penName) {
        this(id, firstName, lastName, penName, null);
    }

    public Author(Long id, String firstName, String lastName, String penName, Set<Post> posts) {
        this(id, firstName, lastName, penName, null, posts);
    }

    public Author(Long id, String firstName, String lastName, String penName, String email, Set<Post> posts) {
        this(id, firstName, lastName, penName, email, null, posts);
    }

    public Author(Long id, String firstName, String lastName, String penName, String email, Set<String> websites, Set<Post> posts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.penName = penName;
        this.email = email;
        this.websites = websites;
        this.posts = posts;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ATR_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "ATR_FRST_NM", length = 25)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    @Column(name = "ATR_LST_NM", length = 25)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "ATR_PEN_NM", length = 15)
    public String getPenName() {
        return penName;
    }

    public void setPenName(String penName) {
        this.penName = penName;
    }

    @NotNull
    @Column(name = "ATR_EML", unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ElementCollection
    public Set<String> getWebsites() {
        return websites;
    }

    public void setWebsites(Set<String> websites) {
        this.websites = websites;
    }

    @ManyToMany
    @JoinColumn(name = "ATR_PSTS")
    @Nullable
    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
