package com.example.emp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String LastName;
    private String emailId;
}
