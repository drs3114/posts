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
 *
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
     *
     */
    public Post() {
        this(null);
    }

    /**
     *
     * @param paragraphs
     */
    public Post(Set<Paragraph> paragraphs) {
        this(null, paragraphs);
    }

    /**
     *
     * @param id
     * @param paragraphs
     */
    public Post(Long id, Set<Paragraph> paragraphs) {
        this(id, paragraphs, null);
    }

    /**
     *
     * @param id
     * @param paragraphs
     * @param notes
     */
    public Post(Long id, Set<Paragraph> paragraphs, String notes) {
        this(id, paragraphs, notes, null);
    }

    /**
     *
     * @param id
     * @param paragraphs
     * @param notes
     * @param genre
     */
    public Post(Long id, Set<Paragraph> paragraphs, String notes, Genre genre) {
        this(id, null, paragraphs, notes, genre);
    }

    /**
     *
     * @param id
     * @param title
     * @param paragraphs
     * @param notes
     * @param genre
     */
    public Post(Long id, String title, Set<Paragraph> paragraphs, String notes, Genre genre) {
        this(id, title, paragraphs, notes, genre, PostType.BLOG);
    }

    /**
     *
     * @param id
     * @param title
     * @param paragraphs
     * @param notes
     * @param genre
     * @param type
     */
    public Post(Long id, String title, Set<Paragraph> paragraphs, String notes, Genre genre, PostType type) {
        this(id, title, paragraphs, notes, genre, type, null);
    }

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
     *
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PST_ID")
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @NotNull
    @Column(name = "PST_TTL")
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    @ManyToMany
    @JoinColumn(name = "PST_PGRPH")
    public Set<Paragraph> getParagraphs() {
        return paragraphs;
    }

    /**
     *
     * @param paragraphs
     */
    public void setParagraphs(Set<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    /**
     *
     * @return
     */
    @Column(name = "PST_NTS")
    public String getNotes() {
        return notes;
    }

    /**
     *
     * @param notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     *
     * @return
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "PST_GNR")
    public Genre getGenre() {
        return genre;
    }

    /**
     *
     * @param genre
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    /**
     *
     * @return
     */
    @Column(name="PST_TYP")
    public PostType getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(PostType type) {
        this.type = type;
    }

    @OneToOne
    @JoinColumn(name = "PST_RCTN")
    public Reaction getReaction() {
        return reaction;
    }

    public void setReaction(Reaction reaction) {
        this.reaction = reaction;
    }
}
