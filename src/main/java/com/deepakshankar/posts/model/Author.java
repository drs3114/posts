package com.deepakshankar.posts.model;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "ATHR")
public class Author {
    private Long id;
    private String firstName;
    private String lastName;
    private String penName;
    private String email;
    private List<String> websites;
    private List<Post> posts;

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

    public Author(Long id, String firstName, String lastName, String penName, List<Post> posts) {
        this(id, firstName, lastName, penName, null, posts);
    }

    public Author(Long id, String firstName, String lastName, String penName, String email, List<Post> posts) {
        this(id, firstName, lastName, penName, email, null, posts);
    }

    public Author(Long id, String firstName, String lastName, String penName, String email, List<String> websites, List<Post> posts) {
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
    public List<String> getWebsites() {
        return websites;
    }

    public void setWebsites(List<String> websites) {
        this.websites = websites;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ATR_PSTS")
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
