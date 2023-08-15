package com.mesbahi.reactive_spring.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/create")
    public Mono<Student> createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping("/all")
    public Flux<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("{id}")
    public Mono<Student> getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

}
