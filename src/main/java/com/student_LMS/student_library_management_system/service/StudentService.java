package com.student_LMS.student_library_management_system.service;

//import com.student_LMS.student_library_management_system.Enum.CardStatus;
//import com.student_LMS.student_library_management_system.converter.StudentConverter;
//import com.student_LMS.student_library_management_system.model.Card;
//import com.student_LMS.student_library_management_system.model.Student;
//import com.student_LMS.student_library_management_system.repository.CardRepository;
//import com.student_LMS.student_library_management_system.repository.StudentRepository;
//import com.student_LMS.student_library_management_system.requestdto.StudentRequestDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class StudentService {
//    // write here business logic
//    @Autowired
//    private CardRepository cardRepository;
//
//    @Autowired
//   private StudentRepository studentRepository;
//    public String saveStudent(StudentRequestDto studentRequestDto){
//     Student student= StudentConverter.convertStudentRequestDtoIntoStudent(studentRequestDto);
//     //whenever we added student data that time card also added at the same time
//        // create a object for card
//        Card card = new Card();
//        card.setCardStatus(CardStatus.ACTIVE);
//         student.setCard(card);
//         card.setStudent(student);
//        studentRepository.save(student);
//        cardRepository.save(card);
//     return "Student data and card data saved successfully";
//    }
//
//}

import com.student_LMS.student_library_management_system.Enum.CardStatus;
import com.student_LMS.student_library_management_system.converter.StudentConverter;
import com.student_LMS.student_library_management_system.model.Card;
import com.student_LMS.student_library_management_system.model.Student;
import com.student_LMS.student_library_management_system.repository.StudentRepository;
import com.student_LMS.student_library_management_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String saveStudent(StudentRequestDto studentRequestDto) {

        // first convert studentrequestdto into student object
        Student student = StudentConverter.convertStudentRequestDtoIntoStudent(studentRequestDto);

//        if(student==null){
//            throw new RuntimeException("student not saved");
//        }

        //whenever the student are added card also issued/added at same time
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);

        student.setCard(card);
        card.setStudent(student);

        studentRepository.save(student);
        return "Student and card saved successfully";
    }

    // here we write the logic of findStudentById
    public Student getStudentById(int id){
      Optional<Student> studentOptional= studentRepository.findById(id);
      if(studentOptional.isPresent()){
          return studentOptional.get();
      }
      else{
          return null;
      }
    }
    //here we write the logic to getAllStudent details
    public List<Student> getAllStudents(){
     List<Student> studentList= studentRepository.findAll();
     return studentList;
    }
    // here we write the logic of updateStudent
    public String UpdateStudent(int id,StudentRequestDto studentRequestDto){
       Student studentId= getStudentById(id);
       if(studentId!=null){
           studentId.setName(studentRequestDto.getName());
           studentId.setDepartment(studentRequestDto.getDepartment());
           studentId.setDob(studentRequestDto.getDob());
           studentId.setEmail(studentRequestDto.getEmail());
           studentId.setMobile(studentRequestDto.getMobile());
           studentId.setGender(studentRequestDto.getGender());
           studentId.setSemester(studentRequestDto.getSemester());
           studentRepository.save(studentId);
           return "student updated";
       }
       else{
           return "student id not found";
       }
    }
    // here write the logic for update specific field
    public String updateMobile(int id,String mobile){
       Student studentId= getStudentById(id);
       if(studentId!=null){
           studentId.setMobile(mobile);
           studentRepository.save(studentId);
           return "Mobile updated";
       }
       else{
           return "id is not found";

       }
    }
    // here we write the logic for deleteStudentById
    public String deleteStudentById(int id){
       studentRepository.deleteById(id);
       return "id is deleted now";
    }
     /*
    pagination - fetching the data or records in the form of pages
    pagenumber- the number of page we want to see(page number starts from 0,1,2,3,4,...)
    pagsize - the total number of record in each page

    database total records - 28, page size -5
    0th page-1-5
    1st page-6-10
    2nd page-11-15
    3rd page-16-20
    4th page-21-25
    5th page-26-28

    database total records - 11, pagesize-2
    0th page-1-2
    1st page-3-4
    2nd page-5-6
    3rd page-7-8
    4th page-9-10
    5th page-11

    database record s-13 pagesize-4
    0th page -1-4
    1st page -5-8
    2nd page - 9-12
    3rd page -13
    4th page - no data

    Sorting - arranging the data or records in ascending or descending order
     */

    // here we write the logic of pagination
    // need two parameter first pageNo,2nd pageSize
    public  List<Student> findAllStudentByPage(int pageNo,int pageSize){
      // only use for pagination  Page<Student> studentPage= studentRepository.findAll(PageRequest.of(pageNo,pageSize));
        //this is not list<> it's a page<> inbuilt method(list)
       // ** pagination with sorting then use below code
        Page<Student> studentPage= studentRepository.findAll(PageRequest.of(pageNo,pageSize,Sort.by("name").ascending()));
        return studentPage.getContent();
    }
}
