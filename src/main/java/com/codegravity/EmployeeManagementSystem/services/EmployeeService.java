package com.codegravity.EmployeeManagementSystem.services;

import com.codegravity.EmployeeManagementSystem.models.Employee;
import com.codegravity.EmployeeManagementSystem.repositories.EmployeeRepository;
import com.codegravity.EmployeeManagementSystem.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(@Valid Employee employee) {
        // Check if email already exists
        if (employeeRepository.findByEmail(employee.getEmail()).isPresent()) {
            throw new DataIntegrityViolationException("Email already exists: " + employee.getEmail());
        }
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }

    public Page<Employee> getEmployeeList(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public Employee getEmployeeDetails(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + employeeId));
    }

    public List<Employee> searchEmployees(String searchTerm) {
        return employeeRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
                searchTerm, searchTerm);
    }

    public Page<Employee> searchEmployees(String searchTerm, Pageable pageable) {
        return employeeRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
                searchTerm, searchTerm, pageable);
    }

    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with email: " + email));
    }

    public Employee updateEmployeeDetails(Long employeeId, @Valid Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + employeeId));

        // Check if new email already exists for a different employee
        if (updatedEmployee.getEmail() != null && 
            !updatedEmployee.getEmail().equals(existingEmployee.getEmail()) &&
            employeeRepository.findByEmail(updatedEmployee.getEmail()).isPresent()) {
            throw new DataIntegrityViolationException("Email already exists: " + updatedEmployee.getEmail());
        }

        // Update only non-null fields
        if (updatedEmployee.getFirstName() != null) {
            existingEmployee.setFirstName(updatedEmployee.getFirstName());
        }
        if (updatedEmployee.getLastName() != null) {
            existingEmployee.setLastName(updatedEmployee.getLastName());
        }
        if (updatedEmployee.getDob() != null) {
            existingEmployee.setDob(updatedEmployee.getDob());
        }
        if (updatedEmployee.getEmail() != null) {
            existingEmployee.setEmail(updatedEmployee.getEmail());
        }
        if (updatedEmployee.getPhone() != null) {
            existingEmployee.setPhone(updatedEmployee.getPhone());
        }
        if (updatedEmployee.getEducationDetails() != null) {
            existingEmployee.setEducationDetails(updatedEmployee.getEducationDetails());
        }
        if (updatedEmployee.getVisaDetails() != null) {
            existingEmployee.setVisaDetails(updatedEmployee.getVisaDetails());
        }

        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + employeeId));
        employeeRepository.delete(employee);
    }
}
