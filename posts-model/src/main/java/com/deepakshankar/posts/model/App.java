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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * This is the entity class that holds the information about the application
 * An application defines a group of posts that belong together
 *
 * @author deepak
 * @version 1.0
 */
@Entity
@Table(name = "APP")
public class App {

    private Long id;
    private String name;
    private AppInfo info;

    /**
     * Default constructor
     */
    public App() {
        this(null);
    }

    /**
     * Builds the application with the name
     *
     * @param name the name of the application
     */
    public App(String name) {
        this(null, name, null);
    }

    /**
     * Builds the application with an Id, Name and the metadata
     * that is defined with {@link AppInfo}
     *
     * @param id   the id of the application
     * @param name the name of the application
     * @param info the metadata about the application
     */
    public App(Long id, String name, AppInfo info) {
        this.id = id;
        this.name = name;
        this.info = info;
    }

    /**
     * Get the Id of the application
     *
     * @return the Id of the application
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "APP_ID")
    public Long getId() {
        return id;
    }

    /**
     * Set the Id of the application
     *
     * @param id the Id of the application
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the name of the application
     *
     * @return the name of the application
     */
    @Column(name = "APP_NM")
    public String getName() {
        return name;
    }

    /**
     * Set the name of the application
     *
     * @param name the name of the application
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the information (metadata) about the application
     *
     * @return the {@link AppInfo} about the application
     */
    @OneToOne
    @JoinColumn(name = "APP_INFO")
    public AppInfo getInfo() {
        return info;
    }

    /**
     * Set the information about the application
     *
     * @param info the {@link AppInfo} of the application
     */
    public void setInfo(AppInfo info) {
        this.info = info;
    }
}