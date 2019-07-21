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

@Entity
@Table(name = "RCTN")
public class Reaction {
    private Long id;
    private Long like;
    private Long dislike;
    private Long sad;
    private Long happy;
    private Long angry;

    public Reaction() {
        this(null);
    }

    public Reaction(Long id) {
        this(id, 0L, 0L, 0L, 0L, 0L);
    }

    public Reaction(Long id, Long like, Long dislike, Long sad, Long happy, Long angry) {
        this.id = id;
        this.like = like;
        this.dislike = dislike;
        this.sad = sad;
        this.happy = happy;
        this.angry = angry;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RCTN_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "RCTN_LIK")
    public Long getLike() {
        return like;
    }

    public void setLike(Long like) {
        this.like = like;
    }

    @Column(name = "RCTN_DSLIK")
    public Long getDislike() {
        return dislike;
    }

    public void setDislike(Long dislike) {
        this.dislike = dislike;
    }

    @Column(name = "RCTN_SAD")
    public Long getSad() {
        return sad;
    }

    public void setSad(Long sad) {
        this.sad = sad;
    }

    @Column(name = "RCTN_HPY")
    public Long getHappy() {
        return happy;
    }

    public void setHappy(Long happy) {
        this.happy = happy;
    }

    @Column(name = "RCTN_AGRY")
    public Long getAngry() {
        return angry;
    }

    public void setAngry(Long angry) {
        this.angry = angry;
    }

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
