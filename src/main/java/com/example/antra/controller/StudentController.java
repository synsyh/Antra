package com.example.antra.controller;

import com.example.antra.entity.Student;
import com.example.antra.repository.StudentClazzRepository;
import com.example.antra.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Yuning Sun
 * @Description
 * @Date 9/1/21
 **/
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentClazzRepository studentClazzRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student findById(@PathVariable Long id) {
        return studentRepository.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestParam String name) {
        Student s = new Student();
        s.setName(name);
        studentRepository.save(s);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateStudent(@PathVariable Long id, @RequestParam String name) {
        Student s = studentRepository.getById(id);
        s.setName(name);
        studentRepository.save(s);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id) {
        Student s = studentRepository.getById(id);
        studentClazzRepository.deleteAll(s.getStudentClazzList());
        studentRepository.deleteById(id);
    }
}
