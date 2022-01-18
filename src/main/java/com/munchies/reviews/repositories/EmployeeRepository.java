package com.munchies.reviews.repositories;

import com.munchies.reviews.models.Employee;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Employee findById(long id);

    Employee findByName(String name);

    boolean existsByName(String name);
}
