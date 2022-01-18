package com.munchies.reviews.controllers;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.munchies.reviews.dtos.AssignFeedbackDto;
import com.munchies.reviews.models.Feedback;
import com.munchies.reviews.models.FeedbackAssignment;
import com.munchies.reviews.models.Review;
import com.munchies.reviews.services.ReviewService;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService service;

    @PutMapping("/reviews/{id}")
    public Review update(@PathVariable Long id, @RequestBody Review review) {
        review.setId(id);
        return service.update(review);
    }

    @PostMapping("/reviews/{id}/assign")
    public FeedbackAssignment assign(@PathVariable Long id, @RequestBody AssignFeedbackDto request) {
        return service.assign(new FeedbackAssignment(id, request.getEmployeeId()));
    }

    @PostMapping("/reviews/{id}/feedbacks")
    public Feedback addFeedback(@PathVariable Long id, @RequestBody Feedback feedback) {
        return service.addFeedback(id, feedback);
    }

    @GetMapping("/reviews/{id}/feedbacks")
    public List<Feedback> getFeedbacks(@PathVariable Long id) {
        return service.getFeedbacks(id);
    }
}
