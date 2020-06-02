package com.penchev.exodia.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "documents")
public class Document extends BaseEntity {
    private String title;
    private String content;

    public Document() {
    }

    @Column
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(columnDefinition = "TEXT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
