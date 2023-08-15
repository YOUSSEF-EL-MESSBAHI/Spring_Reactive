package com.mesbahi.reactive_spring.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Builder
@Table("students")
public class Student {
    @Id
    private Long id;
    private String firstname;
    private String lastname;
    private int age;
}
