package com.library.LibraryManagements.student;

import org.jongo.Jongo;
import org.springframework.stereotype.Component;

import com.library.LibraryManagements.constants.MongoCollectionConstants;
import com.library.LibraryManagements.constants.ResponseConstants;
import com.library.LibraryManagements.exception.LibraryException;
import com.library.LibraryManagements.mongodb.utils.MongoDBUtil;
import com.library.LibraryManagements.student.vo.Student;
import com.library.LibraryManagements.utils.CustomResponse;

@Component("studentDaoImpl")
public class StudentDaoImpl implements StudentDao{

	@Override
	public CustomResponse registerNewStudent(Student student) {
		CustomResponse customresponse = new CustomResponse();		{
			Student existingStudent = new Jongo(MongoDBUtil.getDB()).getCollection(MongoCollectionConstants.STUDENT_DETAILS).findOne("{$or:[{email:#},{mobileNo:#},{studentUsn:#}]}",student.getEmailId(),student.getMobileNo(),student.getStudentUsn()).as(Student.class);

			if (existingStudent !=null) {
				
				if (existingStudent.getMobileNo() == student.getMobileNo()) {
					customresponse.setStatusCode(ResponseConstants.DATA_ALREADY_EXISTS);
					customresponse.setStatusMessage(ResponseConstants.PHONE_EXISTS);
				}
				if (existingStudent.getEmailId().equals(student.getEmailId())) {
					customresponse.setStatusCode(ResponseConstants.DATA_ALREADY_EXISTS);
					customresponse.setStatusMessage(ResponseConstants.EMAIL_EXISTS);
				}if (existingStudent.getStudentUsn().equals(student.getStudentUsn())) {
					customresponse.setStatusCode(ResponseConstants.DATA_ALREADY_EXISTS);
					customresponse.setStatusMessage(ResponseConstants.USN_EXISTS);
				}

			} else {
				new Jongo(MongoDBUtil.getDB()).getCollection(MongoCollectionConstants.STUDENT_DETAILS).insert(student);
				customresponse.setStatusCode(ResponseConstants.SUCCESS);
				customresponse.setStatusMessage(ResponseConstants.REGISTRATION_SUCCESS);
			}
		}
		
		return customresponse;

	}

}
