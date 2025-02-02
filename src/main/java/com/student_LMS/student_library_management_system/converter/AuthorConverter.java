package com.student_LMS.student_library_management_system.converter;

import com.student_LMS.student_library_management_system.model.Author;
import com.student_LMS.student_library_management_system.requestdto.AuthorRequestDto;

public class AuthorConverter {
    public static Author convertAuthorRequestDtoIntoAuthor(AuthorRequestDto authorRequestDto){
        Author author = new Author();

        author.setName(authorRequestDto.getName());
        author.setCountry(authorRequestDto.getCountry());
        author.setEmail(authorRequestDto.getEmail());
        author.setGender(authorRequestDto.getGender());
        author.setRating(authorRequestDto.getRating());

        return author;
    }
}
