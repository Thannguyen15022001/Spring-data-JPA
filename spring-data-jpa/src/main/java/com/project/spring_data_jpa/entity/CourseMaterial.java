package com.project.spring_data_jpa.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Locale;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString(exclude = "course")  // Lombok will remove the course field from the result string when the toString() method because use FetchType.LAZY
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "sequence_course_material",
            sequenceName = "sequence_course_material",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_course_material"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            //cascade = CascadeType.ALL
            cascade = CascadeType.PERSIST,  //Add entity
            fetch = FetchType.LAZY      //Get only data of courseMaterial
            //fetch = FetchType.EAGER      //Get all data of courseMaterial and course entity
    )
    @JoinColumn(
            name = "course_id",   //name of column's courseID
            referencedColumnName = "courseId"  //attribute of course class
    )
    private Course course;
}
