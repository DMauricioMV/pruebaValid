package com.valid.EmployeeManagementBack.services;

import com.valid.EmployeeManagementBack.model.Employee;
import com.valid.EmployeeManagementBack.repository.iEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImplement implements EmployeeService{
    @Autowired
    private iEmployeeRepository employeeRepository;

    public List<Employee> findAll(){
        return (List<Employee>)employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    @Transactional(readOnly = true)
    @Override
    public Employee findById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }
}
