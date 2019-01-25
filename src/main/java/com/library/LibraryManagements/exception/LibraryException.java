package com.library.LibraryManagements.exception;

public class LibraryException extends RuntimeException {
	public LibraryException(String msg, Exception e) {
		super(msg,e);
	}
}
