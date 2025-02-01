package com.student_LMS.student_library_management_system.model;

import com.student_LMS.student_library_management_system.Enum.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "created_date",nullable = false)
    @CreationTimestamp //  it will automatically add the date and time while creating card
    private Date createdDate;
    // Data is predefined data type it automatically select correct time
    @Column(name = "updated_date",nullable = false)
    @UpdateTimestamp //it will automatically add the date and time while updating card
    private Date updatedDate;
    @Column(name = "card_status")
    @Enumerated(value = EnumType.STRING)// this will convert enum value as string while storing in database
//    private CardStatus cardStatus or  private String cardStatus;
    private CardStatus cardStatus;

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
}
