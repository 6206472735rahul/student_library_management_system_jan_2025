package com.student_LMS.student_library_management_system.repository;

import com.student_LMS.student_library_management_system.model.Author;
import com.student_LMS.student_library_management_system.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
