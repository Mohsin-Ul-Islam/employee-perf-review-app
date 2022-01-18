package com.munchies.reviews.repositories;

import java.util.List;

import com.munchies.reviews.models.Feedback;

import org.springframework.data.repository.CrudRepository;

public interface FeedbackRepository extends CrudRepository<Feedback, Long> {

    Feedback findById(long id);

    List<Feedback> findByAssignmentId(Long assignmentId);

}
