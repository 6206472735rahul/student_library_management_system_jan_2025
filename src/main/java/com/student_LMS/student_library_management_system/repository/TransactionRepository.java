package com.student_LMS.student_library_management_system.repository;

import com.student_LMS.student_library_management_system.model.Author;
import com.student_LMS.student_library_management_system.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
