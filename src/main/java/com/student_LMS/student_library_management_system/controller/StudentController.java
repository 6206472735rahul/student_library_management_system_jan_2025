package com.student_LMS.student_library_management_system.controller;

//import com.student_LMS.student_library_management_system.requestdto.StudentRequestDto;
//import com.student_LMS.student_library_management_system.service.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/student/apis")
//public class StudentController {
//    @Autowired
//    private StudentService studentService;
//    @PostMapping("/save")
//    public String saveStudent(@RequestBody StudentRequestDto studentRequestDto){
//       String response= studentService.saveStudent(studentRequestDto);
//       return response;
//    }
//
//}

import com.student_LMS.student_library_management_system.model.Student;
import com.student_LMS.student_library_management_system.requestdto.StudentRequestDto;
import com.student_LMS.student_library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/apis")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @PostMapping("/save")
    public String saveStudent(@RequestBody StudentRequestDto studentRequestDto) {
        String response = studentService.saveStudent(studentRequestDto);
        return response;

    }

     // here we write the api for getStudentById using getMapping
    @GetMapping("/find/{id}")
    public Student getStudentById(@PathVariable int id){
      Student res=  studentService.getStudentById(id);
      return res;
    }
    // here we write the api for getAllStudents using getMapping
    @GetMapping("/findAll")
    public List<Student> getAllStudents(){
     List<Student> studentList= studentService.getAllStudents();
     return studentList;
    }
    // here we write the api for updateStudent using putMapping
    @PutMapping("/update/{id}")
    public String UpdateStudent(@PathVariable int id,@RequestBody StudentRequestDto studentRequestDto){
       String res= studentService.UpdateStudent(id,studentRequestDto);
       return res;
    }
    //here we write the api for updateMobile using patchMapping
    @PatchMapping("/update/{id}")
    public String updateMobile(@PathVariable int id ,@RequestParam String mobile){
     String res=   studentService.updateMobile(id,mobile);
     return res;


    }
    // here we write the api for deleteStudentById using deleteMapping
    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable int id){
     String res=   studentService.deleteStudentById(id);
     return  res;
    }
    //here we write the api for findAllStudentByPage using GetMapping
    @GetMapping("/findAllPage")
    public List<Student> findAllStudentByPage(@RequestParam int pageNo,@RequestParam int pageSSize){
     List<Student> studentPage= studentService.findAllStudentByPage(pageNo,pageSSize);
     return studentPage;

    }


}
