package com.codegravity.EmployeeManagementSystem.controller;

import com.codegravity.EmployeeManagementSystem.models.Employee;
import com.codegravity.EmployeeManagementSystem.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Create a new employee
    @PostMapping("/add")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        Employee savedEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Get all employees (with optional pagination)
    @GetMapping
    public ResponseEntity<?> getAllEmployees(@PageableDefault(size = 10) Pageable pageable,
                                           @RequestParam(required = false) Boolean paginated) {
        if (Boolean.TRUE.equals(paginated)) {
            Page<Employee> employeePage = employeeService.getEmployeeList(pageable);
            return ResponseEntity.ok(employeePage);
        } else {
            List<Employee> employeeList = employeeService.getEmployeeList();
            return ResponseEntity.ok(employeeList);
        }
    }

    // Get an employee by ID
    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
        Employee employee = employeeService.getEmployeeDetails(employeeId);
        return ResponseEntity.ok(employee);
    }

    // Search employees by name (with optional pagination)
    @GetMapping("/search")
    public ResponseEntity<?> searchEmployees(
            @RequestParam String query,
            @PageableDefault(size = 10) Pageable pageable,
            @RequestParam(required = false) Boolean paginated) {
        if (Boolean.TRUE.equals(paginated)) {
            Page<Employee> employees = employeeService.searchEmployees(query, pageable);
            return ResponseEntity.ok(employees);
        } else {
            List<Employee> employees = employeeService.searchEmployees(query);
            return ResponseEntity.ok(employees);
        }
    }

    // Get employee by email
    @GetMapping("/by-email")
    public ResponseEntity<Employee> getEmployeeByEmail(@RequestParam String email) {
        Employee employee = employeeService.findByEmail(email);
        return ResponseEntity.ok(employee);
    }

    // Update an employee by ID
    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId, 
                                                 @Valid @RequestBody Employee employeeDetails) {
        Employee updatedEmployee = employeeService.updateEmployeeDetails(employeeId, employeeDetails);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Delete an employee by ID
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.noContent().build();
    }
}