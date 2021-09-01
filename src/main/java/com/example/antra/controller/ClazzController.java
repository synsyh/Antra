package com.example.antra.controller;

import com.example.antra.entity.Clazz;
import com.example.antra.entity.Student;
import com.example.antra.repository.ClazzRepository;
import com.example.antra.repository.StudentClazzRepository;
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
@RequestMapping("/clazz")
public class ClazzController {
    @Autowired
    ClazzRepository clazzRepository;
    @Autowired
    StudentClazzRepository studentClazzRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)

    public List<Clazz> getClazz() {
        return clazzRepository.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Clazz findById(@PathVariable Long id) {
        return clazzRepository.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addClazz(@RequestParam String name) {
        Clazz c = new Clazz();
        c.setName(name);
        clazzRepository.save(c);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateClazz(@PathVariable Long id, @RequestParam String name) {
        Clazz c = clazzRepository.getById(id);
        c.setName(name);
        clazzRepository.save(c);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClazz(@PathVariable Long id) {
        Clazz c = clazzRepository.getById(id);
        studentClazzRepository.deleteAll(c.getStudentClazzList());
        clazzRepository.delete(c);
    }
}
