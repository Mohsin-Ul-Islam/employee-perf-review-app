package com.munchies.reviews.repositories;

import java.util.List;

import com.munchies.reviews.models.Review;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    Review findById(long id);

    List<Review> findByEmployeeId(Long employeeId);

}
