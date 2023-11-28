package com.harini.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harini.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
