package com.example.antra.entity;

import javax.persistence.*;

/**
 * @Author Yuning Sun
 * @Description
 * @Date 9/1/21
 **/
@Table(name = "student_clazz")
@Entity
public class StudentClazz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "s_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_id")
    private Clazz clazz;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "StudentClazz{" +
                "id='" + id + '\'' +
                ", student=" + student +
                ", clazz=" + clazz +
                '}';
    }
}
