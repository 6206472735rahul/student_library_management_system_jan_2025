package com.student_LMS.student_library_management_system.service;

import com.student_LMS.student_library_management_system.converter.TransactionConverter;
import com.student_LMS.student_library_management_system.model.Book;
import com.student_LMS.student_library_management_system.model.Card;
import com.student_LMS.student_library_management_system.model.Transaction;
import com.student_LMS.student_library_management_system.repository.BookRepository;
import com.student_LMS.student_library_management_system.repository.CardRepository;
import com.student_LMS.student_library_management_system.repository.TransactionRepository;
import com.student_LMS.student_library_management_system.requestdto.TransactionRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    //here we need two extra things because in transaction table
    //present bookId and cardId as a FK
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    public String saveTransaction(TransactionRequestDto transactionRequestDto){
     Transaction transaction =  TransactionConverter.convertTransactionRequestDtoIntoTransaction(transactionRequestDto);
     Book book= bookRepository.findById(transactionRequestDto.getBookId()).get();
     Card card= cardRepository.findById(transactionRequestDto.getCardId()).get();
     transaction.setBook(book);
     transaction.setCard(card);
  transactionRepository.save(transaction);
  return "Transaction saved successfully";
    }


}
