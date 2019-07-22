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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * This is an entity class that provides more
 * information about the {@link App}lication
 *
 * @author deepak
 * @version 1.0
 */
@Entity
@Table(name = "APP_INFO")
public class AppInfo {
    private Long id;
    private String description;
    private String website;
    private List<Author> authors;
    private AppCategory type;

    /**
     * Create an app info with description and the website information
     *
     * @param description the description of the {@link App}
     * @param website     the website for the {@link App}
     */
    public AppInfo(String description, String website) {
        this(description, website, null);
    }

    /**
     * Create an app info with description, website
     * and the authors associated with the application
     *
     * @param description the description of the {@link App}
     * @param website     the website for the {@link App}
     * @param authors     the {@link Author}s associated with the application
     */
    public AppInfo(String description, String website, List<Author> authors) {
        this(null, description, website, authors, null);
    }

    /**
     * Create an app info with an Id, description,
     * website associated with the list of authors and categorize the application
     *
     * @param id          the id of the application
     * @param description the description of the application
     * @param website     the website of the application
     * @param authors     the {@link Author}s associated with the application
     * @param type        the category the application belongs to.
     */
    public AppInfo(Long id, String description, String website, List<Author> authors, AppCategory type) {
        this.id = id;
        this.description = description;
        this.website = website;
        this.authors = authors;
        this.type = type;
    }

    /**
     * get the id of the app info
     *
     * @return the id of the app info
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "APP_INFO_ID")
    public Long getId() {
        return id;
    }

    /**
     * Set the id for the app info
     *
     * @param id the id of the app info
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the description of the app info
     *
     * @return the description of the app info
     */
    @Column(name = "APP_INFO_DESC")
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the app info
     *
     * @param description the description of the app info
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the website associated with the {@link App}
     *
     * @return the website for the {@link App}
     */
    @Column(name = "APP_INFO_WEBST")
    public String getWebsite() {
        return website;
    }

    /**
     * Set the website for the {@link App}
     *
     * @param website the website of the {@link App}
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * Get the authors associated with the {@link App}
     *
     * @return the {@link Author}s associated with the {@link App}lication
     */
    @ManyToMany
    @JoinColumn(name = "APP_INFO_ATHRS")
    public List<Author> getAuthors() {
        return authors;
    }

    /**
     * Set the authors associated with the {@link App}
     *
     * @param authors the {@link Author}s associated with the application
     */
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    /**
     * Get the category of the application
     *
     * @return the category of the application
     */
    @Column(name = "APP_INFO_TYP")
    public AppCategory getType() {
        return type;
    }

    /**
     * Set the category of the application
     *
     * @param type the category of the application
     */
    public void setType(AppCategory type) {
        this.type = type;
    }
}