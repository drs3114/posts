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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * This is an entity class that is used to
 * represent a post (article) from an author
 */
@Entity
@Table(name = "POST")
@DynamicUpdate
public class Post {

    private Long id;
    private String title;
    private Set<Paragraph> paragraphs;
    private String notes;
    private Genre genre;
    private PostType type;
    private Reaction reaction;

    /**
     * Default constructor
     */
    public Post() {
        this(null);
    }

    /**
     * Construct a post object
     *
     * @param paragraphs the paragraphs of the post
     */
    public Post(Set<Paragraph> paragraphs) {
        this(null, paragraphs);
    }

    /**
     * Construct a post object
     *
     * @param id         the id of the post
     * @param paragraphs the paragraphs of the post
     */
    public Post(Long id, Set<Paragraph> paragraphs) {
        this(id, paragraphs, null);
    }

    /**
     * Construct a post object
     *
     * @param id         the id of the post
     * @param paragraphs the paragraphs of the post
     * @param notes      the notes on the post by the author
     */
    public Post(Long id, Set<Paragraph> paragraphs, String notes) {
        this(id, paragraphs, notes, null);
    }

    /**
     * Construct a post object
     *
     * @param id         the id of the post
     * @param paragraphs the paragraphs of the post
     * @param notes      the notes on the post by the author
     * @param genre      the genre the post belongs to
     */
    public Post(Long id, Set<Paragraph> paragraphs, String notes, Genre genre) {
        this(id, null, paragraphs, notes, genre);
    }

    /**
     * Construct a post object
     *
     * @param id         the id of the post
     * @param title      the title of the post
     * @param paragraphs the paragraphs of the post
     * @param notes      the notes on the post by the author
     * @param genre      the genre the post belongs to
     */
    public Post(Long id, String title, Set<Paragraph> paragraphs, String notes, Genre genre) {
        this(id, title, paragraphs, notes, genre, PostType.BLOG);
    }

    /**
     * Construct a post object
     *
     * @param id         the id of the post
     * @param title      the title of the post
     * @param paragraphs the paragraphs of the post
     * @param notes      the notes on the post by the author
     * @param genre      the genre the post belongs to
     * @param type       the type of the post
     */
    public Post(Long id, String title, Set<Paragraph> paragraphs, String notes, Genre genre, PostType type) {
        this(id, title, paragraphs, notes, genre, type, null);
    }

    /**
     * Construct a post object
     *
     * @param id         the id of the post
     * @param title      the title of the post
     * @param paragraphs the paragraphs of the post
     * @param notes      the notes on the post by the author
     * @param genre      the genre the post belongs to
     * @param type       the type of the post
     * @param reaction   the reaction on the post
     */
    public Post(Long id, String title, Set<Paragraph> paragraphs, String notes, Genre genre, PostType type, Reaction reaction) {
        this.id = id;
        this.title = title;
        this.paragraphs = paragraphs;
        this.notes = notes;
        this.genre = genre;
        this.type = type;
        this.reaction = reaction;
    }

    /**
     * Get the id of the post
     *
     * @return the id of the post
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PST_ID")
    public Long getId() {
        return id;
    }

    /**
     * Set the id of the post
     *
     * @param id the id of the post
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the title of the post
     *
     * @return the title of the post
     */
    @NotNull
    @Column(name = "PST_TTL")
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of the post
     *
     * @param title the title of the post
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Set the paragraphs of the post
     *
     * @return the paragraphs of the post
     */
    @ManyToMany
    @JoinColumn(name = "PST_PGRPH")
    public Set<Paragraph> getParagraphs() {
        return paragraphs;
    }

    /**
     * Set the paragraphs of the post
     *
     * @param paragraphs the paragraphs of the post
     */
    public void setParagraphs(Set<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    /**
     * Get the notes of the post
     *
     * @return the notes of the post
     */
    @Column(name = "PST_NTS")
    public String getNotes() {
        return notes;
    }

    /**
     * Set the notes of the post
     *
     * @param notes the notes of the post
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Get the genre of the post
     *
     * @return the genre of the post
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "PST_GNR")
    public Genre getGenre() {
        return genre;
    }

    /**
     * Set the genre of the post
     *
     * @param genre the genre of the post
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    /**
     * Get the type of the post
     *
     * @return the type of the post
     */
    @Column(name = "PST_TYP")
    public PostType getType() {
        return type;
    }

    /**
     * Set the type of the post
     *
     * @param type the type of the post
     */
    public void setType(PostType type) {
        this.type = type;
    }

    /**
     * Get the reactions of the post
     *
     * @return the reactions of the post
     */
    @OneToOne
    @JoinColumn(name = "PST_RCTN")
    public Reaction getReaction() {
        return reaction;
    }

    /**
     * Set the reactions of the post
     *
     * @param reaction the reactions of the post
     */
    public void setReaction(Reaction reaction) {
        this.reaction = reaction;
    }
}
