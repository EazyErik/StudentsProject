package com.github.EazyErik.StudentsProject.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "Gonzo",
                        "gonzo@noIdea.com",
                        LocalDate.of(2000, Month.AUGUST,4),
                        22
                )
        );
    }
}
