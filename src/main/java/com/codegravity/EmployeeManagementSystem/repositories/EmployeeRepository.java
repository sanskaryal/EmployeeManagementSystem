package com.codegravity.EmployeeManagementSystem.repositories;

import com.codegravity.EmployeeManagementSystem.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Find by email (since it's unique)
    Optional<Employee> findByEmail(String email);
    
    // Find by first name or last name containing the search term (case insensitive)
    List<Employee> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);
    
    // Paginated search results
    Page<Employee> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
            String firstName, String lastName, Pageable pageable);
}
