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

/**
 * The category enumeration that defines
 * what category an {@link App}lication belongs to
 *
 * @author deepak
 * @version 1.0
 */
public enum AppCategory {

    /**
     * Entertainment category - not age restriction
     */
    ENTERTAINMENT(0, "ENTERTAINMENT", "Entertainment category"),
    /**
     * Personal Blog category - age restriction moderated
     */
    PERSONAL_BLOG(1, "PERSONAL BLOG", "Personal Blog category"),
    /**
     * Adult category - age restricted
     */
    ADULT(2, "ADULT", "Adult Category");

    private int id;
    private String name;
    private String description;
    private int minAge;
    private boolean ageRestricted;

    /**
     * Construct a new Category
     *
     * @param id          the id of the category
     * @param name        the name of the category
     * @param description the description of the category
     */
    AppCategory(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     * Construct a new category
     *
     * @param id            the id of the category
     * @param name          the name of the category
     * @param description   the description of the category
     * @param minAge        the minimum age to view the content of the {@link App}
     * @param ageRestricted boolean value.
     *                      True - age restriction is ON.
     *                      False - age restriction if OFF
     */
    AppCategory(int id, String name, String description, int minAge, boolean ageRestricted) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.minAge = minAge;
        this.ageRestricted = ageRestricted;
    }

    /**
     * Get the id of the category
     *
     * @return the id of the category
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id of the category
     *
     * @param id the id of the category
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the name of the category
     *
     * @return the name of the category
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the category
     *
     * @param name the name of the category
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the description of the category
     *
     * @return the description of the category
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the category
     *
     * @param description the description of the category
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the minimum age for the category
     *
     * @return the minimum age
     */
    public int getMinAge() {
        return minAge;
    }

    /**
     * Set the minimum age for the category
     *
     * @param minAge the minimum age
     */
    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    /**
     * Tells if the category is age restricted
     *
     * @return true if the category is age restricted. False otherwise
     */
    public boolean isAgeRestricted() {
        return ageRestricted;
    }

    /**
     * Set the age restriction ON or OFF
     *
     * @param ageRestricted true - age restriction is ON
     *                      false - age restriction is OFF
     */
    public void setAgeRestricted(boolean ageRestricted) {
        this.ageRestricted = ageRestricted;
    }
}