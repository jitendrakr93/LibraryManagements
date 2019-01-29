package com.library.LibraryManagements.book;

import java.util.List;

import com.library.LibraryManagements.bookvo.Book;
import com.library.LibraryManagements.exception.LibraryException;
import com.library.LibraryManagements.utils.CustomResponse;

public interface BookDao {

	CustomResponse addBook(List<Book> book)throws LibraryException;

	List<Book> searchBookByName(String bookNamePattern)throws LibraryException;

	List<Book> searchBookByAuthorName(String authorNamePattern)throws LibraryException;

	List<BookCategory> getBookCategory()throws LibraryException;

}
