package com.library.LibraryManagements.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.LibraryManagements.bookvo.Book;
import com.library.LibraryManagements.utils.CustomResponse;

@Service("bookService")
public class BookService {
	 
	@Autowired
	BookDao bookDaoImpl;

	public CustomResponse addBook(Book book) {
		
		int countOfBook=book.getBookQuantity();
		List<Book> bookList=new ArrayList<>();
		for(int i=1;i<=countOfBook;i++) {
			Book bookObject=new Book();
			bookObject.setBookId(book.getBookId());
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
}
