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
import javax.persistence.Table;

/**
 * This is an entity class that is used to capture the sentiment of the post
 *
 * @author deepak
 * @version 1.0
 */
@Entity
@Table(name = "RCTN")
public class Reaction {
    private Long id;
    private Long like;
    private Long dislike;
    private Long sad;
    private Long happy;
    private Long angry;

    /**
     * Default constructor
     */
    public Reaction() {
        this(null);
    }

    /**
     * Construct a reaction
     *
     * @param id the id of the reaction
     */
    public Reaction(Long id) {
        this(id, 0L, 0L, 0L, 0L, 0L);
    }

    /**
     * Construct a reaction
     *
     * @param id      the id of the reaction
     * @param like    count of likes on the posts
     * @param dislike count of dislikes on the posts
     * @param sad     count of sad reactions on the posts
     * @param happy   count of sad reactions on the posts
     * @param angry   count of angry reactions on the posts
     */
    public Reaction(Long id, Long like, Long dislike, Long sad, Long happy, Long angry) {
        this.id = id;
        this.like = like;
        this.dislike = dislike;
        this.sad = sad;
        this.happy = happy;
        this.angry = angry;
    }

    /**
     * Get the id of the reaction
     *
     * @return the id of the reaction
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RCTN_ID")
    public Long getId() {
        return id;
    }

    /**
     * Sets the id of the reaction
     *
     * @param id the id if the reaction
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the like reactions on the posts
     *
     * @return the likes on the posts
     */
    @Column(name = "RCTN_LIK")
    public Long getLike() {
        return like;
    }

    /**
     * Set the likes on the posts
     *
     * @param like the likes on the posts
     */
    public void setLike(Long like) {
        this.like = like;
    }

    /**
     * Get the dislikes on the posts
     *
     * @return the dislikes on the posts
     */
    @Column(name = "RCTN_DSLIK")
    public Long getDislike() {
        return dislike;
    }

    /**
     * Set the dislike on the posts
     *
     * @param dislike the dislike on the posts
     */
    public void setDislike(Long dislike) {
        this.dislike = dislike;
    }

    /**
     * Get the sad reactions on the posts
     *
     * @return sad reactions on the posts
     */
    @Column(name = "RCTN_SAD")
    public Long getSad() {
        return sad;
    }

    /**
     * Set the sad reactions on the posts
     *
     * @param sad the sad reaction on the posts
     */
    public void setSad(Long sad) {
        this.sad = sad;
    }

    /**
     * Get the happy reactions on the posts
     *
     * @return the happy reaction on the posts
     */
    @Column(name = "RCTN_HPY")
    public Long getHappy() {
        return happy;
    }

    /**
     * Set the happy reactions on the posts
     *
     * @param happy the happy reactions on the posts
     */
    public void setHappy(Long happy) {
        this.happy = happy;
    }

    /**
     * Get the angry reactions on the posts
     *
     * @return the angry reactions on the posts
     */
    @Column(name = "RCTN_AGRY")
    public Long getAngry() {
        return angry;
    }

    /**
     * Set the angry reactions on the posts
     *
     * @param angry the angry reactions on the posts
     */
    public void setAngry(Long angry) {
        this.angry = angry;
    }

    /**
     * Update the reactions count on the posts
     *
     * @param reaction the reaction object containing the sentiments to be updated
     * @return the updated reactions on the posts
     */
    public Reaction update(final Reaction reaction) {
        if (reaction.getLike() != null) {
            this.like += reaction.getLike();
        }
        if (reaction.getDislike() != null) {
            this.dislike += reaction.getDislike();
        }
        if (reaction.getSad() != null) {
            this.sad += reaction.getSad();
        }
        if (reaction.getHappy() != null) {
            this.happy += reaction.getHappy();
        }
        if (reaction.getAngry() != null) {
            this.angry += reaction.getAngry();
        }
        return this;
    }
}
