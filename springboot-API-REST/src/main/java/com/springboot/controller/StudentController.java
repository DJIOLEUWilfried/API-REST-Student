package com.springboot.controller;

import com.springboot.model.Student;
import com.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping
    public Student createStudentController(@RequestBody Student student) {
        return this.studentService.createStudent(student);
    }

    @PutMapping(path = "/{id}")
    public Student updateStudentController(@PathVariable Long id, @RequestBody Student student) {
        return this.studentService.updateStudent(id, student) ;
    }

    @DeleteMapping
    public void deleteStudentController(@PathVariable Long id) {
        this.studentService.deleteStudent(id);
    }

    @GetMapping(path = "/{id}")
    public Student getStudentByIdControlller(@PathVariable Long id) {
        return this.studentService.findStudentById(id);
    }

    @GetMapping
    public List<Student> getAllStudentController() {
       return this.studentService.findAllStudent();
    }

}

