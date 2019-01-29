package com.library.LibraryManagements.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.LibraryManagements.bookvo.Book;
import com.library.LibraryManagements.exception.LibraryException;
import com.library.LibraryManagements.utils.AutoIncrement;
import com.library.LibraryManagements.utils.CustomResponse;

@Service("bookService")
public class BookService {
	 
	@Autowired
	BookDao bookDaoImpl;

	public CustomResponse addBook(Book book) throws LibraryException{
		
		int countOfBook=book.getBookQuantity();
		List<Book> bookList=new ArrayList<>();
		for(int i=1;i<=countOfBook;i++) {
			Book bookObject=new Book();
			long bookId=AutoIncrement.getNextSequenceBookId();
			bookObject.setBookId(bookId);
			bookObject.setBookName(book.getBookName());
			bookObject.setAuthorName(book.getAuthorName());
			bookObject.setBookMasterType(book.getBookMasterType());
			bookObject.setBookCategoryName(book.getBookCategoryName());
			bookObject.setPerUnitPrice(book.getPerUnitPrice());
			bookObject.setBookQuantity(1);
			bookObject.setIssuedStatus(false);
			bookList.add(bookObject);
		}
		return bookDaoImpl.addBook(bookList);
	}

	public List<Book> searchBookByName(String bookNamePattern)throws LibraryException {
		return bookDaoImpl.searchBookByName(bookNamePattern);
	}

	public List<Book> searchBookByAuthorName(String authorNamePattern) throws LibraryException{
		return bookDaoImpl.searchBookByAuthorName(authorNamePattern);
	}

	public List<BookCategory> getBookCategory() throws LibraryException{
		return bookDaoImpl.getBookCategory();
	}
}
