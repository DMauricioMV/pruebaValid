package com.valid.EmployeeManagementBack.services;

import com.valid.EmployeeManagementBack.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee save(Employee employee);

    public Employee findById(Long id);
}
