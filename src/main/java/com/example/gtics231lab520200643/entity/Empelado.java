package com.example.gtics231lab520200643.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "employees")
public class Empelado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String phone_number;
    private LocalDate hire_date;

    private String job_id;
    private int manager_id;
    private int department_id;

}
