package com.project.spring_data_jpa.repository;

import com.project.spring_data_jpa.entity.Guardian;
import com.project.spring_data_jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                        .name("Vy xinh")
                        .phone("123456789")
                        .email("tuongvy78@gmail.com")
                        .build();

        Student student = Student.builder()
                .firstName("Than")
                .lastName("Nguyen")
                .guardian(guardian)
                .email("thannguyen79@gmail.com")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void findStudentWithGuardian() {
        List<Student> students = studentRepository.findByGuardianName("Vy xinh");
        System.out.println("Students found: " + students);
    }

    @Test
    public void findStudentByEmail() {
        Student students = studentRepository.getStudentsByEmail("thannguyen79@gmail.com");
        System.out.println("Students found: " + students);
    }

    @Test
    public void findFirstNameByEmail() {
        String firstName = studentRepository.getFirstNameByEmail("thannguyen79@gmail.com");
        System.out.println("First name found: " + firstName);
    }

    @Test
    public void findStudentByEmailNative(){
        Student students = studentRepository.getStudentByEmailNative("thannguyen79@gmail.com");
        System.out.println("Students found: " + students);
    }

    @Test
    public void findStudentByEmailNativeNameParam(){
        Student students = studentRepository.getStudentByEmailNativeNameParam("thannguyen79@gmail.com");
        System.out.println("Students found: " + students);
    }

    @Test
    public void updateFirstNameStudentByEmail() {
        studentRepository.updateFirstNameStudentByEmail("Than 1502", "thannguyen79@gmail.com");
    }
}