package com.student_LMS.student_library_management_system.model;

//import com.student_LMS.student_library_management_system.Enum.CardStatus;
//import jakarta.persistence.*;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Entity
//@Table(name = "card")
//public class Card {
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @Column(name = "created_date",nullable = false)
//    @CreationTimestamp //  it will automatically add the date and time while creating card
//    private Date createdDate;
//    // Data is predefined data type it automatically select correct time
//    @Column(name = "updated_date",nullable = false)
//    @UpdateTimestamp //it will automatically add the date and time while updating card
//    private Date updatedDate;
//    @Column(name = "card_status")
//    @Enumerated(value = EnumType.STRING)// this will convert enum value as string while storing in database
////    private CardStatus cardStatus or  private String cardStatus;
//    private CardStatus cardStatus;
//    // made relation b/w student and card (@OneToOne)
//    @OneToOne
//    @JoinColumn // it helps us to join student id column in my card column as a foreign key(FK)
//    private Student student;
//
//    // made relation b/w card and book (@OneToMany)
//    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
//    private List<Book> bookList= new ArrayList<>();
//    // if we have one card then you can take multiple books
//    // that's why i am using here arrayList
//
//    // made relation b/w card and transaction (@OneToMany)
//    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
//    private List<Transaction>transactionList= new ArrayList<>();
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public Date getUpdatedDate() {
//        return updatedDate;
//    }
//
//    public void setUpdatedDate(Date updatedDate) {
//        this.updatedDate = updatedDate;
//    }
//
//    public CardStatus getCardStatus() {
//        return cardStatus;
//    }
//
//    public void setCardStatus(CardStatus cardStatus) {
//        this.cardStatus = cardStatus;
//    }
//
//    public void setStudent(Student student) {
//    }
//}

import com.student_LMS.student_library_management_system.Enum.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="card")
public class Card {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="created_date", nullable = false)
    @CreationTimestamp // it will automatically add the data and time while creating card
    private Date createdDate;

    @Column(name="updated_date")
    @UpdateTimestamp // it will automatically add the data and time while updating card
    private Date updatedDate;

    @Column(name="card_status", nullable = false)
    @Enumerated(value = EnumType.STRING)// this will convert enum value as string while storing in database
    private CardStatus cardStatus;

   // @JsonBackReference
    @OneToOne
    @JoinColumn // it joins the primary key of student table as foreign key in card table
    private Student student;

    //@JsonManagedReference
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Book> bookList = new ArrayList<>();

   // @JsonManagedReference
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Transaction> transactionList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
