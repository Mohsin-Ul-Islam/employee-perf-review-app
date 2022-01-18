package com.munchies.reviews.models;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "feedback_assignments")
public class FeedbackAssignment {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "review_id")
    private Long reviewId;

    @Column(name = "employee_id")
    private Long employeeId;

    protected FeedbackAssignment() {
    }

    public FeedbackAssignment(Long reviewId, Long employeeId) {
        this.reviewId = reviewId;
        this.employeeId = employeeId;
    }

    public Long getId() {
        return this.id;
    }

    public Long getReviewId() {
        return this.reviewId;
    }

    public void setReviewId(Long id) {
        this.reviewId = id;
    }

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Long id) {
        this.employeeId = id;
    }
}
