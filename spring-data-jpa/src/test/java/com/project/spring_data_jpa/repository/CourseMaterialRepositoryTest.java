package com.project.spring_data_jpa.repository;

import com.project.spring_data_jpa.entity.Course;
import com.project.spring_data_jpa.entity.CourseMaterial;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void SaveCourseMaterial() {
        Course course = Course.builder()
                .title("DSA")
                .credit(10)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .course(course)
                .url("WWW.google.com")
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void getCourseMaterial() {
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("All course material" + courseMaterials);
    }

}