package com.library.LibraryManagements.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.LibraryManagements.student.vo.Student;
import com.library.LibraryManagements.utils.CustomResponse;

@Service("studentService")
public class StudentService {
	
	@Autowired
	StudentDao studentDaoImpl;

	public CustomResponse registerNewStudent(Student student) {
		return studentDaoImpl.registerNewStudent(student);
	}
	
	
	

}
