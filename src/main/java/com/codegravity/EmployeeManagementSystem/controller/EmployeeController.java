package com.codegravity.EmployeeManagementSystem.controller;

import com.codegravity.EmployeeManagementSystem.models.Employee;
import com.codegravity.EmployeeManagementSystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private List<Employee> employees = new ArrayList<>();

    // Create a new employee
    @PostMapping("/add")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employees;
    }

    // Get an employee by ID
    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable String employeeId) {
        Optional<Employee> employee = employees.stream()
                .filter(e -> e.getEmployeeId().equals(employeeId))
                .findFirst();
        return employee.orElse(null);
    }

    // Update an employee by ID
    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable String employeeId, @RequestBody Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getEmployeeId().equals(employeeId)) {
                employees.set(i, updatedEmployee);
                return updatedEmployee;
            }
        }
        return null; // Employee not found
    }

    // Delete an employee by ID
    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId) {
        employees.removeIf(employee -> employee.getEmployeeId().equals(employeeId));
        return "Employee with ID " + employeeId + " has been deleted.";
    }
}