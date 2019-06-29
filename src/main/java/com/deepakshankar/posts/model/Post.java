package com.deepakshankar.posts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "POST")
public class Post {

    private Long id;
    private List<Paragraph> paragraphs;
    private Author author;
    private String notes;

    public Post() {
    }

    public Post(List<Paragraph> paragraphs) {
        this(paragraphs, null);
    }

    public Post(List<Paragraph> paragraphs, Author author) {
        this(null, paragraphs, author);
    }

    public Post(Long id, List<Paragraph> paragraphs, Author author) {
        this(id, paragraphs, author, null);
    }

    public Post(Long id, List<Paragraph> paragraphs, Author author, String notes) {
        this.id = id;
        this.paragraphs = paragraphs;
        this.author = author;
        this.notes = notes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PST_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "PST_PGRPH")
    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    @OneToOne
    @JoinColumn(name = "PST_ATHR")
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Column(name = "PST_NTS")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
