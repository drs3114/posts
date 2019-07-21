package com.deepakshankar.posts.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PRGRPH")
@DynamicUpdate
public class Paragraph {

    private Long id;
    private String content;
    private Integer order;

    public Paragraph() {

    }

    public Paragraph(final String content) {
        this(null, content);
    }

    public Paragraph(final Long id, final String content) {
        this(id, content, null);
    }

    public Paragraph(final Long id, final String content, final Integer order) {
        this.id = id;
        this.content = content;
        this.order = order;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PG_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "PG_CNTNT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "PG_ORDR")
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
