package com.student_LMS.student_library_management_system.controller;

import com.student_LMS.student_library_management_system.model.Author;
import com.student_LMS.student_library_management_system.requestdto.AuthorRequestDto;
import com.student_LMS.student_library_management_system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("author/apis")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    // create a api for author
    @PostMapping("/save")
    public String saveAuthor(@RequestBody AuthorRequestDto authorRequestDto){
      String response= authorService.saveAuthor(authorRequestDto);
      return response;
    }
}
