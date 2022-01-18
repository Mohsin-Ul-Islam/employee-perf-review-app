package com.munchies.reviews.controllers;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.munchies.reviews.models.Review;
import com.munchies.reviews.models.Employee;
import com.munchies.reviews.services.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/employees/{id}")
    public Employee get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping("/employees")
    public List<Employee> list() {
        return service.list();
    }

    @PostMapping("/employees")
    public Employee create(@RequestBody Employee employee) {
        return service.create(employee);
    }

    @PostMapping("/employees/{id}/reviews")
    public Review addReview(@PathVariable Long id, @RequestBody Review review) {
        return service.addReview(id, review);
    }

    @GetMapping("/employees/{id}/reviews")
    public List<Review> getReviews(@PathVariable Long id) {
        return service.getReviews(id);
    }

    @PutMapping("/employees/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return service.update(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
