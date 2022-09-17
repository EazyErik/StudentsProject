package com.github.EazyErik.StudentsProject.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository
                .findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);


    }

    public void deleteStudent(Long studentId) {
        boolean existsById = studentRepository.existsById(studentId);
        if(!existsById){
            throw  new IllegalStateException("student with id: " + studentId + " does not exist!");
        }
        studentRepository.deleteById(studentId);


    }
}
