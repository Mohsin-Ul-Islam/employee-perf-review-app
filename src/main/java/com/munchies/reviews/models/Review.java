package com.munchies.reviews.models;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "employee_id")
    private Long employeeId;

    protected Review() {
    }

    public Review(String title) {
        this.title = title;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setEmployeeId(Long id) {
        this.employeeId = id;
    }

    public Long getEmployeeId() {
        return this.employeeId;
    }

}
