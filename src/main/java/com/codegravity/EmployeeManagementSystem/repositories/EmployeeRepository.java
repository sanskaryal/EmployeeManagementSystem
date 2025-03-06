package com.codegravity.EmployeeManagementSystem.repositories;

import com.codegravity.EmployeeManagementSystem.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Optional<Employee> findByEmployeeId(Long employeeId);

}
