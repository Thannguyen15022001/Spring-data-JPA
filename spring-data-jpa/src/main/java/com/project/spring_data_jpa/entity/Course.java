package com.project.spring_data_jpa.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
}
