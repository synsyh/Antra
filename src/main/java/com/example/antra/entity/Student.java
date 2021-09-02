package com.example.antra.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Yuning Sun
 * @Description
 * @Date 9/1/21
 **/
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<StudentClazz> studentClazzList = new ArrayList<>();

    public List<StudentClazz> getStudentClazzList() {
        return studentClazzList;
    }

    public void setStudentClazzList(StudentClazz sc) {
        this.studentClazzList.add(sc);
    }

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
