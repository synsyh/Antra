package com.example.antra.repository;

import com.example.antra.entity.StudentClazz;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Yuning Sun
 * @Description
 * @Date 9/1/21
 **/
public interface StudentClazzRepository extends JpaRepository<StudentClazz, Long> {
}
