package com.example.antra.controller;

import com.example.antra.entity.Clazz;
import com.example.antra.entity.Student;
import com.example.antra.entity.StudentClazz;
import com.example.antra.repository.ClazzRepository;
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
@RequestMapping("/student_clazz")
public class StudentClazzController {
    @Autowired
    StudentClazzRepository studentClazzRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ClazzRepository clazzRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentClazz> getStudents() {
        return studentClazzRepository.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentClazz findById(@PathVariable Long id) {
        return studentClazzRepository.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addRelation(@RequestParam Long sId, @RequestParam Long cId) {
        StudentClazz sc = new StudentClazz();
        Student s = studentRepository.getById(sId);
        Clazz c = clazzRepository.getById(cId);
        sc.setStudent(s);
        sc.setClazz(c);
        s.setStudentClazzList(sc);
        c.setStudentClazzList(sc);
        studentClazzRepository.save(sc);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateRelation(@PathVariable Long id, @RequestParam Long sId, @RequestParam Long cId) {
        StudentClazz s = studentClazzRepository.findById(id).get();
        s.setStudent(studentRepository.getById(sId));
        s.setClazz(clazzRepository.getById(cId));
        studentClazzRepository.save(s);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRelation(@PathVariable Long id) {
        studentClazzRepository.deleteById(id);
    }
}
