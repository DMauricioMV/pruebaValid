package com.valid.EmployeeManagementBack.repository;

import com.valid.EmployeeManagementBack.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iEmployeeRepository extends JpaRepository<Employee, Long> {
}
