package com.github.EazyErik.StudentsProject.student;

import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }


    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);

    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId ){
        studentService.deleteStudent(studentId);

    }

    @PutMapping(path = "{studentId}")
    public void updateStuden(
    @PathVariable("studentId") Long studentId,
    @RequestParam(required = false) String name,
    @RequestParam(required = false) String email){
        studentService.updateStudent(studentId,name,email);



    }



}
