package com.munchies.reviews.repositories;

import com.munchies.reviews.models.FeedbackAssignment;

import org.springframework.data.repository.CrudRepository;

public interface FeedbackAssignmentRepository extends CrudRepository<FeedbackAssignment, Long> {

    FeedbackAssignment findById(long id);

    FeedbackAssignment findByReviewIdAndEmployeeId(Long reviewId, Long employeeId);

}
