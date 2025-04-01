package com.project.spring_data_jpa.repository;

import com.project.spring_data_jpa.entity.Course;
import com.project.spring_data_jpa.entity.CourseMaterial;
import com.project.spring_data_jpa.entity.Student;
import com.project.spring_data_jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import javax.print.attribute.standard.PageRanges;
import org.springframework.data.domain.Pageable;
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
        //course.addStudent(student);

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords = (Pageable) PageRequest.of(0,3);

        Pageable secondPageWithTwoRecords = (Pageable) PageRequest.of(0,2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

        long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();

        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("Total elements: " + totalElements);
        System.out.println("Total pages: " + totalPages);

        System.out.println("Course: " + courses);
    }
}