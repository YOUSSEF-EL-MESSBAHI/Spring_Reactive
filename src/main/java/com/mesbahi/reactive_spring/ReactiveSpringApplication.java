package com.mesbahi.reactive_spring;

import com.mesbahi.reactive_spring.student.Student;
import com.mesbahi.reactive_spring.student.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveSpringApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(StudentRepo repository) {
        return args -> {
            for (int i = 0; i < 3000; i++) {
                repository.save(
                        Student.builder()
                                .firstname("Test" + i)
                                .lastname("test" + i)
                                .age(i)
                                .build()
                ).subscribe();
            }
        };
    }
}
