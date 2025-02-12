package com.exampleproject.restdemo.controller;

import com.exampleproject.restdemo.mode.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    Employee employee;
    @GetMapping("{employeeId}")
    public Employee getEmployeeDetails(String employeeId){
        return employee;
                //new Employee("E1","Employee F", "Employee L","Employee dob", "****");
    }

    @PostMapping
    public String createEmployeeDetails(@RequestBody Employee employee){
        this.employee = employee;
        return "Employee Created Successfully";
    }

    @PutMapping
    public String updateEmployeeDetails(@RequestBody Employee employee){
        this.employee = employee;
        return "Employee Updated Successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteEmployeeDetails(String employeeId){
        this.employee = null;
        return "Employee Deleted Successfully";
    }


}
