package com.student_LMS.student_library_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentLibraryManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentLibraryManagementSystemApplication.class, args);
		System.out.println("This is LMS project running on port number 6778");
	}

}
