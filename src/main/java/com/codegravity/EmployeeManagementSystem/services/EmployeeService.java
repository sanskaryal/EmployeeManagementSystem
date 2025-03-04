package com.codegravity.EmployeeManagementSystem.services;


import com.codegravity.EmployeeManagementSystem.models.Employee;
import com.codegravity.EmployeeManagementSystem.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee e) {
        return employeeRepository.save(e);
    }

    public List<Employee> getEmployeeList(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeDetails(String employeeId){
        return employeeRepository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employeeId));
    }

    public Employee updateEmployeeDetails(String employeeId, Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employeeId));

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


}
