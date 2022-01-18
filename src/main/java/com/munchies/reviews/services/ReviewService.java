package com.munchies.reviews.services;

import java.util.List;

import com.munchies.reviews.models.Feedback;
import com.munchies.reviews.models.FeedbackAssignment;
import com.munchies.reviews.models.Review;

public interface ReviewService {

    public Review update(Review review);

    public Feedback addFeedback(Long id, Feedback feedback);

    public List<Feedback> getFeedbacks(Long id);

    public FeedbackAssignment assign(FeedbackAssignment assignment);

}
