package com.library.LibraryManagements.book;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.library.LibraryManagements.bookvo.Book;
import com.library.LibraryManagements.exception.LibraryException;
import com.library.LibraryManagements.utils.CustomResponse;

@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;
	
	private static final Logger logger = Logger.getLogger(BookController.class);
	
	@RequestMapping(value = "/addbook", method = RequestMethod.POST, headers = "Accept=application/json")
	public CustomResponse addBook(@RequestBody Book book) {
		CustomResponse customResponse=null;
		try {
			System.out.println("---->"+new Gson().toJson(book));
			customResponse=bookService.addBook(book);
		}catch (LibraryException e) {
			logger.error("Getting Error While Adding Book", e);
		}
		return customResponse;
	}
	
	@RequestMapping(value = "/searchBookByName", method = RequestMethod.GET)
	public List<Book> searchBookByName(String bookNamePattern) {
		List<Book> bookList=null;
		try {
			bookList=bookService.searchBookByName(bookNamePattern);
		}catch (LibraryException e) {
			logger.error("Getting Error While Searching Book by Name", e);
		}
		return bookList;
	}
	
	@RequestMapping(value = "/searchBookByAuthorName", method = RequestMethod.GET)
	public List<Book> searchBookByAuthorName(String authorNamePattern) {
		List<Book> bookList=null;
		try {
			bookList=bookService.searchBookByAuthorName(authorNamePattern);
		}catch (LibraryException e) {
			logger.error("Getting Error While Searching Book by Author Name", e);
		}
		return bookList;
	}
	
	@RequestMapping(value = "/getBookCategory", method = RequestMethod.GET)
	public List<BookCategory> getBookCategory() {
		List<BookCategory> bookCategoryList=null;
		try {
			bookCategoryList=bookService.getBookCategory();
		}catch (LibraryException e) {
			logger.error("Getting Error While getting book category", e);
		}
		return bookCategoryList;
	}
	
}
