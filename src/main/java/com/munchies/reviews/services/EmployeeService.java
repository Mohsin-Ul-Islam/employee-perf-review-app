package com.munchies.reviews.services;

import com.munchies.reviews.models.Employee;
import com.munchies.reviews.models.Review;

import java.util.List;

public interface EmployeeService {

    public Employee get(Long id);

    public List<Employee> list();

    public Employee create(Employee employee);

    public Employee update(Employee employee);

    public void delete(Long id);

    public Review addReview(Long id, Review review);

    public List<Review> getReviews(Long id);

}
