package com.deepakshankar.posts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "APP_INFO")
public class AppInfo {
    private Long id;
    private String description;
    private String website;
    private List<Author> authors;
    private AppCategory type;

    public AppInfo(String description, String website) {
        this(description, website, null);
    }

    public AppInfo(String description, String website, List<Author> authors) {
        this(null, description, website, authors, null);
    }

    public AppInfo(Long id, String description, String website, List<Author> authors, AppCategory type) {
        this.id = id;
        this.description = description;
        this.website = website;
        this.authors = authors;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "APP_INFO_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "APP_INFO_DESC")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "APP_INFO_WEBST")
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @ManyToMany
    @JoinColumn(name = "APP_INFO_ATHRS")
    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Column(name = "APP_INFO_TYP")
    public AppCategory getType() {
        return type;
    }

    public void setType(AppCategory type) {
        this.type = type;
    }
}