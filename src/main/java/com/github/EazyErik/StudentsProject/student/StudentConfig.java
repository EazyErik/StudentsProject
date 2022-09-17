package com.github.EazyErik.StudentsProject.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;


import static java.time.Month.*;

@Configuration
public class StudentConfig {


    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args ->{
            Student gonzo = new Student(
                    "Gonzo",
                    "gonzo@noIdea.com",
                    LocalDate.of(2000, AUGUST, 4)

            );

            Student peter = new Student(
                    "Peter",
                    "peter@noIdea.com",
                    LocalDate.of(2000, AUGUST, 18)

            );

            repository.saveAll(
                    List.of(gonzo,peter)
            );

        };
    }
}
