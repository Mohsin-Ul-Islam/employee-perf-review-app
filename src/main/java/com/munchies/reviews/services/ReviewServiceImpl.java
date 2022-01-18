package com.munchies.reviews.services;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.munchies.reviews.models.Feedback;
import com.munchies.reviews.models.FeedbackAssignment;
import com.munchies.reviews.models.Employee;
import com.munchies.reviews.models.Review;
import com.munchies.reviews.repositories.EmployeeRepository;
import com.munchies.reviews.repositories.FeedbackAssignmentRepository;
import com.munchies.reviews.repositories.FeedbackRepository;
import com.munchies.reviews.repositories.ReviewRepository;

import java.util.List;

import com.munchies.reviews.exceptions.EntityNotFoundException;
import com.munchies.reviews.exceptions.FeedbackAlreadyAssignedException;

@Component
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private FeedbackAssignmentRepository feedbackAssignmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Review get(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("review", id));
    }

    public Review update(Review review) {

        Review _review = repository.findById(review.getId())
                .orElseThrow(() -> new EntityNotFoundException("review", review.getId()));

        _review.setTitle(review.getTitle());
        return repository.save(_review);

    }

    public Feedback addFeedback(Long id, Feedback feedback) {

        Review review = this.get(id);
        FeedbackAssignment feedbackAssignment = feedbackAssignmentRepository.findByReviewIdAndEmployeeId(review.getId(),
                review.getEmployeeId());

        if (feedbackAssignment == null)
            throw new EntityNotFoundException("FeedbackAssignment", review.getId());

        feedback.setAssignmentId(feedbackAssignment.getId());

        return feedbackRepository.save(feedback);
    }

    public List<Feedback> getFeedbacks(Long id) {
        Review review = this.get(id);
        FeedbackAssignment feedbackAssignment = feedbackAssignmentRepository.findByReviewIdAndEmployeeId(review.getId(),
                review.getEmployeeId());

        if (feedbackAssignment == null)
            throw new EntityNotFoundException("FeedbackAssignment", review.getId());

        return feedbackRepository.findByAssignmentId(feedbackAssignment.getId());
    }

    public FeedbackAssignment assign(FeedbackAssignment assignment) {
        Review review = this.get(assignment.getReviewId());
        Employee employee = employeeRepository.findById(assignment.getEmployeeId())
                .orElseThrow(() -> new EntityNotFoundException("Employee", assignment.getEmployeeId()));

        if (feedbackAssignmentRepository.findByReviewIdAndEmployeeId(review.getId(),
                employee.getId()) != null)
            throw new FeedbackAlreadyAssignedException(review.getId(), employee.getId());

        FeedbackAssignment feedbackAssignment = new FeedbackAssignment(review.getId(), employee.getId());
        return feedbackAssignmentRepository.save(feedbackAssignment);

    }

}
