package com.munchies.reviews.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.munchies.reviews.models.Employee;
import com.munchies.reviews.models.Review;
import com.munchies.reviews.repositories.EmployeeRepository;
import com.munchies.reviews.repositories.ReviewRepository;
import com.munchies.reviews.exceptions.EntityNotFoundException;
import com.munchies.reviews.exceptions.EmployeeNameAlreadyExistsException;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private ReviewRepository reviewRepository;

    public Employee get(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("employee", id));
    }

    public List<Employee> list() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Employee create(Employee employee) {

        if (repository.existsByName(employee.getName())) {
            throw new EmployeeNameAlreadyExistsException(employee.getName());
        }

        return repository.save(employee);
    }

    public Employee update(Employee employee) {

        if (!repository.existsById(employee.getId())) {
            throw new EntityNotFoundException("employee", employee.getId());
        }

        return repository.save(employee);

    }

    public void delete(Long id) {
        repository.delete(this.get(id));
    }

    public Review addReview(Long id, Review review) {

        review.setEmployeeId(this.get(id).getId());
        return reviewRepository.save(review);

    }

    public List<Review> getReviews(Long id) {
        return reviewRepository.findByEmployeeId(this.get(id).getId());
    }
}
