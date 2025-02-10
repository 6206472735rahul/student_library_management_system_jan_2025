package com.student_LMS.student_library_management_system.repository;

import com.student_LMS.student_library_management_system.model.Author;
import com.student_LMS.student_library_management_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    // customized queries - writing our own user defined queries
    // 1. With JPA support writing our own queries using fields or attributes
    public Student findByEmail(String email); //here name should have use a/c to jpa
    public List<Student> findByDepartment(String dept);

    public List<Student> findBySemesterAndDepartment(String sem, String dept);

    public List<Student> findBySemesterOrDepartment(String sem, String dept);

    // 2. writing own sql queries
    //select * from student_library_management_system_2025.student  where email="Rahul.r206@gmail.com";
    @Query(nativeQuery = true,value = "select * from student  where email=:email1")
    public Student getEmailByQuery(String email1); // here method naming anything

}
