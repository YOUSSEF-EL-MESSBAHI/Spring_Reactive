package com.mesbahi.reactive_spring.student;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface StudentRepo extends ReactiveCrudRepository<Student, Long>{
    Flux<Student> findAllByFirstnameIgnoreCase(String firstname);
}
