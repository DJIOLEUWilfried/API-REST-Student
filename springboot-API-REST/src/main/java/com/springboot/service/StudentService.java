package com.springboot.service;

import com.springboot.Exception.StudentNotFoundException;
import com.springboot.model.Student;
import com.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository ;

    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {

        return this.studentRepository.save(student) ;
    }

    public Student updateStudent(Long id, Student student) {
        Optional<Student> studentExist = this.studentRepository.findById(id) ;

        if (!studentExist.isPresent()) {

            throw new StudentNotFoundException(String.format("Student with id '%d' not found !", id)) ;
        }

        return this.studentRepository.save(student) ;
    }

    public void deleteStudent(Long id) {

        Optional<Student> studentExist = this.studentRepository.findById(id) ;

        if (studentExist.isPresent()) {
            throw new StudentNotFoundException(String.format("Student with id '%d' not found !", id)) ;
        }

        this.studentRepository.delete(studentExist.get()) ;
    }


    public Optional<Student> findStudentById(Long id) {

//        return this.studentRepository.findById(id)
//                .orElseThrow(() -> new StudentNotFoundException (
//                        String.format("Student with id '%d' not found !", id)
//                ));
        Optional<Student> studentExist = this.studentRepository.findById(id) ;

        if (!studentExist.isPresent()) {

            throw new StudentNotFoundException(String.format("Student with id '%d' not found !", id)) ;
        }

        return this.studentRepository.findById(id) ;
    }



    public List<Student> findAllStudent() {
        return this.studentRepository.findAll();
    }




}
