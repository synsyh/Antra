package com.example.antra;

import com.example.antra.entity.Student;
import com.example.antra.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class AntraApplication {

    public static void main(String[] args) {
        SpringApplication.run(AntraApplication.class, args);
    }
}
