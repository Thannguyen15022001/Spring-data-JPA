package com.project.spring_data_jpa.repository;

import com.project.spring_data_jpa.entity.Course;
import com.project.spring_data_jpa.entity.Teacher;
import jakarta.persistence.SequenceGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course coursePy = Course.builder()
                .title("Python")
                .credit(10)
                .build();

        Course courseJava = Course.builder()
                .title("Java")
                .credit(5)
                .build();

        Teacher teacherHana = Teacher.builder()
                //.courses(List.of(coursePy, courseJava))
                .firstName("Hana")
                .lastName("Marris")
                .build();
        Teacher teacherAn =  Teacher.builder()
                //.courses(List.of(coursePy, courseJava))
                .firstName("An")
                .lastName("Dang")
                .build();

        teacherRepository.saveAll(List.of(teacherHana, teacherAn));

    }
}