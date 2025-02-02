package com.student_LMS.student_library_management_system.service;

import com.student_LMS.student_library_management_system.Enum.CardStatus;
import com.student_LMS.student_library_management_system.converter.StudentConverter;
import com.student_LMS.student_library_management_system.model.Card;
import com.student_LMS.student_library_management_system.model.Student;
import com.student_LMS.student_library_management_system.repository.StudentRepository;
import com.student_LMS.student_library_management_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    // write here business logic
    @Autowired
   private StudentRepository studentRepository;
    public String saveStudent(StudentRequestDto studentRequestDto){
     Student student= StudentConverter.convertStudentRequestDtoIntoStudent(studentRequestDto);
     //whenever we added student data that time card also added at the same time
        // create a object for card
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);

        student.setCard(card);
        card.setStudent(student);
        studentRepository.save(student);
     return "Student data and card data saved successfully";
    }

}
