package com.Project.employeeManager.service;

import com.Project.employeeManager.exception.UserNotFoundException;
import com.Project.employeeManager.model.Employee;
import com.Project.employeeManager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepo repo;

    @Autowired
    public EmployeeService(EmployeeRepo repo) {
        this.repo = repo;
    }

    public Employee addEmployee(Employee employee) {
        return repo.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return repo.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return repo.findById(id).
                orElseThrow(()-> new UserNotFoundException("User of ID: " + id + " Not Found"));
    }

    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }

}
