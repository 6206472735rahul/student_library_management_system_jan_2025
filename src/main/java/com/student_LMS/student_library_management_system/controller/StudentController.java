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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/apis")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @PostMapping("/save")
    public ResponseEntity<String> saveStudent(@RequestBody StudentRequestDto studentRequestDto) {
        try {
            String response = studentService.saveStudent(studentRequestDto);
            // for return the data in standard entity we use
            //ResponseEntity<String>, if you not aware of data type
            // then return ResponseEntity<?>
            return ResponseEntity.ok(response);
            //ResponseEntity.ok it's return success message
        }
        catch (Exception e){
         return   ResponseEntity.internalServerError().body("Exception occurred: "+e.getMessage());
         //ResponseEntity.internalServerError().body it's return internal server error 500
        }


    }

     // here we write the api for getStudentById using getMapping
    @GetMapping("/find/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id){
        try {
            Student res=  studentService.getStudentById(id);
            return ResponseEntity.ok(res);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error occurred: "+ e.getMessage());

        }

    }
    // here we write the api for getAllStudents using getMapping
    @GetMapping("/findAll")
    public ResponseEntity<?> getAllStudents(){
        try {
            List<Student> studentList= studentService.getAllStudents();
            return ResponseEntity.ok(studentList);
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error occurred"+ e.getMessage());

        }

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
    // here we write the api for email using getMapping
    @GetMapping("/findByEmail")
    public Student findStudentByEmail(@RequestParam String email){
      Student student=  studentService.findStudentByEmail(email);
      return student;

    }
    //here we write the api for department using getMapping
    @GetMapping("/findByDepartment")
    public List<Student>  findStudentByDepartment(@RequestParam String dept){
       List<Student> studentList= studentService.findStudentByDepartment(dept);
       return studentList;
    }
    // here we write the api for findStudentBySemesterAndDepartment using getMapping
    @GetMapping("/findBySemesterAndDepartment")
    public  List<Student> findStudentBySemesterAndDepartment(@RequestParam String sem,@RequestParam String dept){
        List<Student> studentList= studentService.findStudentBySemesterAndDepartment(sem,dept);
        return  studentList;
    }
    // here we write the api for findStudentBySemesterorDepartment using getMapping
    @GetMapping("/findBySemesterOrDepartment")
    public  List<Student> findStudentBySemesterOrDepartment(@RequestParam String sem,@RequestParam String dept){
        List<Student> studentList= studentService.findStudentBySemesterAndDepartment(sem,dept);
        return  studentList;
    }
    // here we write the api for sql query using getMapping
    @GetMapping("/findEmailByQuery")
    public Student getEmailByQuery(@RequestParam String email){
      Student student=  studentService.getEmailByQuery(email);
      return  student;

    }


}
