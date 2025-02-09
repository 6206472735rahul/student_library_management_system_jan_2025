package com.student_LMS.student_library_management_system.model;

//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "student")
//public class Student {
//    @Id // it's denoted primary key id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    // this is id comes automatically from backend (inbuilt)
//    // id is generated separately for each table
//    // this annotation follow order sequence and maintain it
//    private int id;
//    @Column(name="name", nullable = false)
//    private String name;
//
//    @Column(name="email", unique = true, nullable = false)
//    private String email;
//
//    @Column(name = "gender")
//    private String gender;
//
//    @Column(name = "mobile", nullable = false)
//    private String mobile;
//
//    @Column(name = "sem", nullable = false)
//    private String semester;
//
//    @Column(name = "department", nullable = false)
//    private String department;
//
//    @Column(name = "dob", nullable = false)
//    private String dob;
// //made relation b/w student and card (@OneToOne)
//    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
//    // mappedBy means link create b/w student and card
//    //cascade means :- if you try to delete from student table then also
//    //automatically deleted from card table because of OneToOne relation
//    private Card card;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getMobile() {
//        return mobile;
//    }
//
//    public void setMobile(String mobile) {
//        this.mobile = mobile;
//    }
//
//    public String getSemester() {
//        return semester;
//    }
//
//    public void setSemester(String semester) {
//        this.semester = semester;
//    }
//
//    public String getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }
//
//    public String getDob() {
//        return dob;
//    }
//
//    public void setDob(String dob) {
//        this.dob = dob;
//    }
//
//    public void setCard(Card card) {
//    }
//}

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name ="student")
public class Student {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this will automatically generate id in backend database
    private int id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="email", unique = true, nullable = false)
    private String email;

    @Column(name = "gender")
    private String gender;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Column(name = "sem", nullable = false)
    private String semester;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "dob", nullable = false)
    private String dob;

    @JsonManagedReference // it helps to stop same data printing again and again
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Card card;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}

