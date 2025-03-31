package com.project.spring_data_jpa.repository;

import com.project.spring_data_jpa.entity.Course;
import com.project.spring_data_jpa.entity.CourseMaterial;
import com.project.spring_data_jpa.entity.Student;
import com.project.spring_data_jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void getAllCourse() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("All course: " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("John")
                .lastName("Doe")
                .build();

        Course course = Course.builder()
                .title("C++")
                .teacher(teacher)
                .credit(12)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void addCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Suka")
                .lastName("Minako")
                .build();

        Student student = Student.builder()
                .firstName("Nobita")
                .lastName("Uzumaki")
                .email("Nobita@gmail.com")
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("AI.google.com")
                .build();

        Course course = Course.builder()
                .title("AI")
                .teacher(teacher)
                .credit(12)
                //.courseMaterial(courseMaterial)
                .build();
        course.addStudent(student);

        courseRepository.save(course);
    }
}