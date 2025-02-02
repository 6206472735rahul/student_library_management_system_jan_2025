package com.student_LMS.student_library_management_system.requestdto;

import com.student_LMS.student_library_management_system.Enum.CardStatus;

public class CardRequestDto {
    private CardStatus cardStatus;
    private int studentId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }
}
