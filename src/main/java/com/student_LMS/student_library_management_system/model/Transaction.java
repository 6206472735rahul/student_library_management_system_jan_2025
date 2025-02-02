package com.student_LMS.student_library_management_system.model;

import com.student_LMS.student_library_management_system.Enum.TransactionType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "transaction_type",nullable = false)
    private TransactionType transactionType;
    @Column(name = "transaction_date",nullable = false)
    @CreationTimestamp
    private Date transactionDate;
    @Column(name = "due_date",nullable = false)
    private String dueDate;
    @Column(name = "fine",nullable = false)
    private double fine;

    // made relation b/w Transaction and book
    // for transaction  @ManyToOne
    @ManyToOne
    @JoinColumn
    private Book book;
    // made relation b/w Transaction and Card
    // for transaction  @ManyToOne
    @ManyToOne
    @JoinColumn
    private Card card;




}
