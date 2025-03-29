package com.project.spring_data_jpa.repository;

import com.project.spring_data_jpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Meta;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByLastNameNotNull();

    List<Student> findByFirstNameContaining(String firstName);

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    //JPQL
    @Query("select S from Student S where S.email = ?1")
    Student getStudentsByEmail(String email);

    //JPQL
    @Query("SELECT S.firstName FROM Student S WHERE S.email=?1")
    String getFirstNameByEmail(String email);

    //Native query
    @Query(
            value = "SELECT * FROM tbl_student S WHERE S.email_address=?1",
            nativeQuery = true
    )
    Student getStudentByEmailNative(String email);

    //Native name param query
    @Query(
            value = "SELECT * FROM tbl_student S WHERE S.email_address= :emailID",
            nativeQuery = true
    )
    Student getStudentByEmailNativeNameParam(@Param("emailID") String email);

    //Update Query
    @Modifying  //If you want to use update, delete, insert command you have to define modifying
    @Transactional
    /*
    Update, delete, or insert statements need to be executed within a transaction to ensure data integrity..
    @Transactional ensures that the SQL statement is executed in a short transaction, and will:
        Commit automatically if successful
        Rollback if an error occurs
     */
    @Query(
            value = "UPDATE tbl_student SET first_name = :firstName WHERE email_address = :emailID",
            nativeQuery = true
    )
    int updateFirstNameStudentByEmail(@Param("firstName") String firstName,@Param("emailID") String email);
}
