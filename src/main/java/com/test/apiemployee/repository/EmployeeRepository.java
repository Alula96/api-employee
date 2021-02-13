package com.test.apiemployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.apiemployee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> { }
