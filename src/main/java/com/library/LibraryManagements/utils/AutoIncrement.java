package com.library.LibraryManagements.utils;

import org.jongo.Jongo;

import com.library.LibraryManagements.exception.LibraryException;
import com.library.LibraryManagements.mongodb.utils.MongoDBUtil;


public class AutoIncrement {

	private static final String SEQUENCE_BOOK_ID = "bookId";
	private static final String SEQUENCE_SUBADMIN_ID = "subAdminId";
	private static final String SEQUENCE_SUPERADMIN_ID = "superAdminId";
	private static final String SEQUENCE_STUDENT_ID = "studentId";
	

	private static Long generateSequenceId(String name) throws LibraryException {
		try {
			new Jongo(MongoDBUtil.getDB()).getCollection("counters").update("{ _id:# }", name).with("{$inc:{seq:1}}");
			Counters counters = new Jongo(MongoDBUtil.getDB()).getCollection("counters").findOne("{ _id: #}", name)
					.as(Counters.class);
			return Double.valueOf(counters.getSeq()).longValue();
		} catch (Exception e) {
			throw new LibraryException("Exception occured while generating sequence in util", e);
		}
	}

	public static Long getNextSequenceBookId() throws LibraryException {
		return generateSequenceId(SEQUENCE_BOOK_ID);
	}

	public static Long getNextSequenceForSubAdminId() throws LibraryException {
		return generateSequenceId(SEQUENCE_SUBADMIN_ID);
	}

	public static Long getNextSequenceForSuperAdminID() throws LibraryException {
		return generateSequenceId(SEQUENCE_SUPERADMIN_ID);
	}

	public static Long getNextSequenceForStudentId() throws LibraryException {
		return generateSequenceId(SEQUENCE_STUDENT_ID);
	}

}

class Counters {
	private String _id;
	private double seq;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public double getSeq() {
		return seq;
	}

	public void setSeq(double seq) {
		this.seq = seq;
	}

}
