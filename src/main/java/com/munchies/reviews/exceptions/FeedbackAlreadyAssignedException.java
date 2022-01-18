package com.munchies.reviews.exceptions;

public class FeedbackAlreadyAssignedException extends RuntimeException {

    public FeedbackAlreadyAssignedException(Long reviewId, Long employeeId) {
        super(String.format("FeedbackAssigment(reviewId=%d, employeeId=%d) already exists.", reviewId, employeeId));
    }

}
