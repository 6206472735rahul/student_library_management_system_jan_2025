package com.student_LMS.student_library_management_system.converter;

import com.student_LMS.student_library_management_system.model.Card;
import com.student_LMS.student_library_management_system.requestdto.CardRequestDto;

public class CardConverter {
    public static Card convertCardRequestDtoIntoCard(CardRequestDto cardRequestDto){
        Card card = new Card();
        card.setCardStatus(cardRequestDto.getCardStatus());
        return card;
    }
}
