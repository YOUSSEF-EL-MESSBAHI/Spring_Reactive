package com.mesbahi.reactive_spring.student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class StudentService {
    private final StudentRepo studentRepo;
    public Flux<Student> getAllStudents(){
        return studentRepo.findAll().delayElements(java.time.Duration.ofSeconds(1));
    }
    public Mono<Student> getStudentById(Long id){
        return studentRepo.findById(id);
    }
    public Mono<Student> createStudent(Student student){
        return studentRepo.save(student);
    }
    public Mono<Student> updateStudent(Long id, Student student){
        return studentRepo.findById(id)
                .flatMap(s -> {
                    s.setFirstname(student.getFirstname());
                    s.setLastname(student.getLastname());
                    s.setAge(student.getAge());
                    return studentRepo.save(s);
                });
    }
    public Mono<Void> deleteStudent(Long id){
        return studentRepo.deleteById(id);
    }
    public Flux<Student> getStudentByFirstname(String firstname){
        return studentRepo.findAllByFirstnameIgnoreCase(firstname);
    }
}
