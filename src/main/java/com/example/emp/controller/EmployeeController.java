package com.example.emp.controller;

import com.example.emp.model.Employee;
import com.example.emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173/")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmp(employee);
    }
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return  employeeService.getAllEmp();
    }
}
