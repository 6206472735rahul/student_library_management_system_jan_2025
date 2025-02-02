package com.student_LMS.student_library_management_system.converter;

import com.student_LMS.student_library_management_system.model.Transaction;
import com.student_LMS.student_library_management_system.requestdto.TransactionRequestDto;

public class TransactionConverter {
    // converter - used to convert the request dto inputs into model class which saves in database
    public static Transaction convertTransactionRequestDtoIntoTransaction(TransactionRequestDto transactionRequestDto){
        Transaction transaction = new Transaction();
        transaction.setTransactionType(transactionRequestDto.getTransactionType());
        transaction.setDueDate(transactionRequestDto.getDueDate());
        transaction.setFine(transactionRequestDto.getFine());
        return transaction;
    }
}
