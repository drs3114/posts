package com.deepakshankar.posts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *
 */
@Entity
@Table(name = "POST")
public class Post {

    private Long id;
    private String title;
    private List<Paragraph> paragraphs;
    private Author author;
    private String notes;
    private Genre genre;
    private PostType type;

    /**
     *
     */
    public Post() {
    }

    /**
     *
     * @param paragraphs
     */
    public Post(List<Paragraph> paragraphs) {
        this(paragraphs, null);
    }

    /**
     *
     * @param paragraphs
     * @param author
     */
    public Post(List<Paragraph> paragraphs, Author author) {
        this(null, paragraphs, author);
    }

    /**
     *
     * @param id
     * @param paragraphs
     * @param author
     */
    public Post(Long id, List<Paragraph> paragraphs, Author author) {
        this(id, paragraphs, author, null);
    }

    /**
     *
     * @param id
     * @param paragraphs
     * @param author
     * @param notes
     */
    public Post(Long id, List<Paragraph> paragraphs, Author author, String notes) {
        this(id, paragraphs, author, notes, null);
    }

    /**
     *
     * @param id
     * @param paragraphs
     * @param author
     * @param notes
     * @param genre
     */
    public Post(Long id, List<Paragraph> paragraphs, Author author, String notes, Genre genre) {
        this(id, null, paragraphs, author, notes, genre);
    }

    /**
     *
     * @param id
     * @param title
     * @param paragraphs
     * @param author
     * @param notes
     * @param genre
     */
    public Post(Long id, String title, List<Paragraph> paragraphs, Author author, String notes, Genre genre) {
        this(id, title, paragraphs, author, notes, genre, PostType.BLOG);
    }

    /**
     *
     * @param id
     * @param title
     * @param paragraphs
     * @param author
     * @param notes
     * @param genre
     * @param type
     */
    public Post(Long id, String title, List<Paragraph> paragraphs, Author author, String notes, Genre genre, PostType type) {
        this.id = id;
        this.title = title;
        this.paragraphs = paragraphs;
        this.author = author;
        this.notes = notes;
        this.genre = genre;
        this.type = type;
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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "PST_PGRPH")
    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    /**
     *
     * @param paragraphs
     */
    public void setParagraphs(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    /**
     *
     * @return
     */
    @OneToOne
    @JoinColumn(name = "PST_ATHR")
    public Author getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     */
    public void setAuthor(Author author) {
        this.author = author;
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
}
