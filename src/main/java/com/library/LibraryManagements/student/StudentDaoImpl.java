package com.library.LibraryManagements.student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jongo.Jongo;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.library.LibraryManagements.constants.MongoCollectionConstants;
import com.library.LibraryManagements.constants.ResponseConstants;
import com.library.LibraryManagements.exception.LibraryException;
import com.library.LibraryManagements.mongodb.utils.MongoDBUtil;
import com.library.LibraryManagements.student.vo.Student;
import com.library.LibraryManagements.utils.CustomResponse;

@Component("studentDaoImpl")
public class StudentDaoImpl implements StudentDao {

	@Override
	public CustomResponse registerNewStudent(Student student) {
		CustomResponse customresponse = new CustomResponse();
		try {
			Student existingStudent = new Jongo(MongoDBUtil.getDB())
					.getCollection(MongoCollectionConstants.STUDENT_DETAILS)
					.findOne("{$or:[{email:#},{mobileNo:#},{studentUsn:#}]}", student.getEmailId(),
							student.getMobileNo(), student.getStudentUsn())
					.as(Student.class);

			if (existingStudent != null) {

				if (existingStudent.getMobileNo() == student.getMobileNo()) {
					customresponse.setStatusCode(ResponseConstants.DATA_ALREADY_EXISTS);
					customresponse.setStatusMessage(ResponseConstants.PHONE_EXISTS);
				}
				if (existingStudent.getEmailId().equals(student.getEmailId())) {
					customresponse.setStatusCode(ResponseConstants.DATA_ALREADY_EXISTS);
					customresponse.setStatusMessage(ResponseConstants.EMAIL_EXISTS);
				}
				if (existingStudent.getStudentUsn().equals(student.getStudentUsn())) {
					customresponse.setStatusCode(ResponseConstants.DATA_ALREADY_EXISTS);
					customresponse.setStatusMessage(ResponseConstants.USN_EXISTS);
				}

			} else {
				new Jongo(MongoDBUtil.getDB()).getCollection(MongoCollectionConstants.STUDENT_DETAILS).insert(student);
				customresponse.setStatusCode(ResponseConstants.SUCCESS);
				customresponse.setStatusMessage(ResponseConstants.REGISTRATION_SUCCESS);
			}
		}catch (LibraryException e) {
			throw new LibraryException("Getting Error While Rehistring The Student", e);
		}

		return customresponse;

	}

	@Override
	public List<Student> findStudentByName(String namePattern) throws LibraryException {
		List<Student> studentList = new ArrayList<>();
		try {
			Iterator<Student> existingStudent = new Jongo(MongoDBUtil.getDB())
					.getCollection(MongoCollectionConstants.STUDENT_DETAILS)
					.find("{studentName:{$regex:#,$options:'i'}}", namePattern).as(Student.class).iterator();
			while (existingStudent.hasNext()) {
				Student stu = existingStudent.next();
				studentList.add(stu);
			}
		} catch (LibraryException e) {
			throw new LibraryException("Getting Error While Searching Student By Name", e);
		}

		return studentList;
	}

	@Override
	public Student findStudentByUSN(String usn) throws LibraryException {
		Student existingStudent=null;
		try {
			existingStudent = new Jongo(MongoDBUtil.getDB())
					.getCollection(MongoCollectionConstants.STUDENT_DETAILS)
					.findOne("{studentUsn:#}", usn)
					.as(Student.class);
		}catch(LibraryException e) {
			throw new LibraryException("Getting Error While Searching Student By USN", e);
		}
		
		return existingStudent;
	}

}
