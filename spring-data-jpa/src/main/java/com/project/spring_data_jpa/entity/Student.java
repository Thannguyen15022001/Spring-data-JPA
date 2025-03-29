package com.project.spring_data_jpa.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name="tbl_student",
        uniqueConstraints = @UniqueConstraint(  // defined unique for email no the same email
                name = "emailid_unique",
                columnNames = "email_address"
        )
)
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private int studentId;
    private String firstName;
    private String lastName;

    @Column(
            name = "email_address",
            nullable = false
    )
    private String email;

    @Embedded
    private Guardian guardian;

    //Using embedded from class guardian
    //private String guardianName;
    //private String guardianEmail;
    //private String guardianPhone;
}
