package com.example.emp.controller;

import com.example.emp.model.Employee;
import com.example.emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
        boolean deleted = false;
        deleted = employeeService.deleteEmp(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted",deleted);
        return  ResponseEntity.ok(response);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeService.getEmpById(id);
        return ResponseEntity.ok(employee);
    }
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        Employee employee1 = employeeService.updateEmp(id,employee);
        return  ResponseEntity.ok(employee1);
    }
}
