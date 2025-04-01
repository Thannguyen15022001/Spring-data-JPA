package com.project.spring_data_jpa.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "students")
public class Course {

    @Id
    @SequenceGenerator(
            name = "sequence_course",
            sequenceName = "sequence_course",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_course"
    )
    private Long courseId;
    private String title;
    private Integer credit;


    //Mapping courseMaterial into course
    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherID"
    )
    private Teacher teacher;

    @ManyToMany(
            cascade = CascadeType.ALL
            //fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "student_course_mapping",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    private List<Student> students;

    public void addStudent(Student student) {
        if(students == null)
            students = new ArrayList<>();
        students.add(student);
    }
}
