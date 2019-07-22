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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * The entity class that represents a paragraph of the post
 *
 * @author deepak
 * @version 1.0
 */
@Entity
@Table(name = "PRGRPH")
@DynamicUpdate
public class Paragraph {

    private Long id;
    private String content;
    private Integer order;

    /**
     * default constructor
     */
    public Paragraph() {

    }

    /**
     * Construct a paragraph
     *
     * @param content the content of the paragraph
     */
    public Paragraph(final String content) {
        this(null, content);
    }

    /**
     * Construct a paragraph
     *
     * @param id      the id of the paragraph
     * @param content the content of the paragraph
     */
    public Paragraph(final Long id, final String content) {
        this(id, content, null);
    }

    /**
     * Construct a paragraph
     *
     * @param id      the id of the paragraph
     * @param content the content of the paragraph
     * @param order   the order of the paragraph in the post
     */
    public Paragraph(final Long id, final String content, final Integer order) {
        this.id = id;
        this.content = content;
        this.order = order;
    }

    /**
     * Get the id of the paragraph
     *
     * @return the id of the paragraph
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PG_ID")
    public Long getId() {
        return id;
    }

    /**
     * Set the id of the paragraph
     *
     * @param id the id of the paragraph
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the content of the paragraph
     *
     * @return the content of the paragraph
     */
    @NotNull
    @Column(name = "PG_CNTNT")
    public String getContent() {
        return content;
    }

    /**
     * Set the content of the paragraph
     *
     * @param content the content of the paragraph
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Get the order of the paragraph
     *
     * @return the order of the paragraph
     */
    @Column(name = "PG_ORDR")
    public int getOrder() {
        return order;
    }

    /**
     * Set the order of the paragraph
     *
     * @param order the order of the paragraph
     */
    public void setOrder(int order) {
        this.order = order;
    }
}
