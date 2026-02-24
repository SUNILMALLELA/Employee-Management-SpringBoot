package com.example.emp.service;

import com.example.emp.entity.EmployeeEntity;
import com.example.emp.model.Employee;
import com.example.emp.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public Employee createEmp(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee,employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }
    public List<Employee> getAllEmp(){
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<Employee> employees = employeeEntities
                .stream()
                .map(emp-> new Employee(
                        emp.getId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmailId()
                ))
                .collect(Collectors.toList());
        return employees;
    }
    public boolean deleteEmp(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeRepository.delete(employeeEntity);
        return true;

    }

    public Employee getEmpById(Long id) {
       EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
       Employee employee = new Employee();
       BeanUtils.copyProperties(employeeEntity,employee);
       return  employee;
    }

    public Employee updateEmp(Long id, Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeEntity.setEmailId(employee.getEmailId());
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeRepository.save(employeeEntity);
        return employee;
    }
}
































