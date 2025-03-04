package com.codegravity.EmployeeManagementSystem.controller;

import com.codegravity.EmployeeManagementSystem.models.Employee;
import com.codegravity.EmployeeManagementSystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employeeList = employeeService.getEmployeeList();
        return ResponseEntity.ok(employeeList);
    }

    // Get an employee by ID
    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String employeeId) {
        Employee employee = employeeService.getEmployeeDetails(employeeId);
        return ResponseEntity.ok(employee);
    }

    // Update an employee by ID
    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String employeeId, @RequestBody Employee employeeDetails) {
        Employee updatedEmployee = employeeService.updateEmployeeDetails(employeeId, employeeDetails);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Delete an employee by ID
    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId) {
        employees.removeIf(employee -> employee.getEmployeeId().equals(employeeId));
        return "Employee with ID " + employeeId + " has been deleted.";
    }
}