package com.project.spring_data_jpa.entity;


import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        // mapping attribute from Guardian class to column of tbl_student tabel
        @AttributeOverride(
                name = "name",
                column = @Column( name = "guardian_name")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardian_email")
        ),
        @AttributeOverride(
                name = "phone",
                column = @Column(name = "guardian_phone")
        )
})
public class Guardian {
    private String name;
    private String email;
    private String phone;
}
