package com.library.LibraryManagements.student;

import java.util.List;

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
			throw new LibraryException("Getting Error While Registering Student", e);
		}
		return customResponse;
	}
	
	@RequestMapping(value = "/searchStudentByName", method = RequestMethod.GET)
	public List<Student> findStudentByName(String namePattern) {
		List<Student> studentList=null;
		try {
			studentList=studentService.findStudentByName(namePattern);
		}catch (LibraryException e) {
			throw new LibraryException("Getting Error While Fetcning  Student By Name", e);
		}
		return studentList;
	}
	
	@RequestMapping(value = "/searchStudentByUSN", method = RequestMethod.GET)
	public Student findStudentByUSN(String usn) {
		Student student=null;
		try {
			student=studentService.findStudentByUSN(usn);
		}catch (LibraryException e) {
			throw new LibraryException("Getting Error While fetching Student By USN", e);
		}
		return student;
	}
		
	
}
