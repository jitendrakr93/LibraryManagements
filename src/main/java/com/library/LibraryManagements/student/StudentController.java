package com.library.LibraryManagements.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.library.LibraryManagements.exception.LibraryException;
import com.library.LibraryManagements.student.vo.Student;
import com.library.LibraryManagements.utils.CustomResponse;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	
	@RequestMapping(value = "/studentregistration", method = RequestMethod.POST, headers = "Accept=application/json")
	public CustomResponse registrationUser(@RequestBody Student student) {
		CustomResponse customResponse=null;
		try {
			customResponse=studentService.registerNewStudent(student);
		}catch (LibraryException e) {
			throw new LibraryException("Getting Error While Registering User", e);
		}
		return customResponse;
	}
		
	
}
