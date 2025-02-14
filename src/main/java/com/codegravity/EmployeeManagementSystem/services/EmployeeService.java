package com.codegravity.EmployeeManagementSystem.services;


import com.codegravity.EmployeeManagementSystem.models.Employee;
import com.codegravity.EmployeeManagementSystem.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee e) {
        return employeeRepository.save(e);
    }
}
