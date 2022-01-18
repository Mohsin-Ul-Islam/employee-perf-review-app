package com.munchies.reviews.models;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "assignment_id")
    private Long assignmentId;

    protected Feedback() {
    }

    public Feedback(String content) {
        this.content = content;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setAssignmentId(Long id) {
        this.assignmentId = id;
    }

    public Long getAssignmentId() {
        return this.assignmentId;
    }

}
