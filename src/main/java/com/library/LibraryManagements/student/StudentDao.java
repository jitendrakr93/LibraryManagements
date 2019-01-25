package com.library.LibraryManagements.student;

import com.library.LibraryManagements.exception.LibraryException;
import com.library.LibraryManagements.student.vo.Student;
import com.library.LibraryManagements.utils.CustomResponse;

public interface StudentDao {

	CustomResponse registerNewStudent(Student student)throws LibraryException;
	
}
