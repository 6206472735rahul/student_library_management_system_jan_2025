package com.student_LMS.student_library_management_system.service;

import com.student_LMS.student_library_management_system.converter.BookConverter;
import com.student_LMS.student_library_management_system.model.Author;
import com.student_LMS.student_library_management_system.model.Book;
import com.student_LMS.student_library_management_system.model.Card;
import com.student_LMS.student_library_management_system.repository.AuthorRepository;
import com.student_LMS.student_library_management_system.repository.BookRepository;
import com.student_LMS.student_library_management_system.repository.CardRepository;
import com.student_LMS.student_library_management_system.requestdto.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CardRepository cardRepository;

    public String saveBook(BookRequestDto bookRequestDto){
        Book book = BookConverter.convertBookRequestDtoIntoBook(bookRequestDto);

        //here we have have to add authorid and cardid as well

        Author author = authorRepository.findById(bookRequestDto.getAuthorId()).get();
        book.setAuthor(author);

        Card card=cardRepository.findById(bookRequestDto.getCardId()).get();
        book.setCard(card);

        bookRepository.save(book);
        return "Book saved successfully";
    }
}