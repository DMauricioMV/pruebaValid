package com.valid.EmployeeManagementBack.controller;

import com.valid.EmployeeManagementBack.model.Employee;
import com.valid.EmployeeManagementBack.services.EmployeeServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired(required = true)
    private EmployeeServiceImplement employeeServiceImplement;

    @GetMapping("/employee/findAll")
    public List<Employee> index(){
        return employeeServiceImplement.findAll();
    }

    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.OK)
    public Employee create(@RequestBody Employee employee){
        return employeeServiceImplement.save(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee show(@PathVariable Long id){
        return employeeServiceImplement.findById(id);
    }

    @PutMapping("/employee/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee update(@RequestBody Employee employee, @PathVariable Long id){
        Employee employeeA = employeeServiceImplement.findById(id);

        employeeA.setProcessed(employee.isProcessed());

        return employeeServiceImplement.save(employeeA);
    }
}
