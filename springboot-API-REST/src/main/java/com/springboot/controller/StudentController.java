package com.springboot.controller;

import com.springboot.model.Student;
import com.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/student")
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudentController(@RequestBody Student student) {

        // System.out.println("\n\n Valeur === " + student);

        return this.studentService.createStudent(student);
    }

    @PutMapping(path = "/{id}")
    public Student updateStudentController(@PathVariable Long id, @RequestBody Student student) {
        return this.studentService.updateStudent(id, student) ;
    }

    @DeleteMapping("/{id}")
    public void deleteStudentController(@PathVariable Long id) {
        System.out.println("\n\n Nous y sommes " );
        this.studentService.deleteStudent(id);
    }

    @GetMapping(path = "/{id}")
    public Optional<Student> getStudentByIdControlller(@PathVariable Long id) {
        return this.studentService.findStudentById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudentController() {
       return this.studentService.findAllStudent();
    }

}

