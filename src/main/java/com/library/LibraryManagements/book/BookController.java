package com.library.LibraryManagements.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.LibraryManagements.bookvo.Book;
import com.library.LibraryManagements.exception.LibraryException;
import com.library.LibraryManagements.utils.CustomResponse;

@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/addbook", method = RequestMethod.POST, headers = "Accept=application/json")
	public CustomResponse addBook(@RequestBody Book book) {
		CustomResponse customResponse=null;
		try {
			customResponse=bookService.addBook(book);
		}catch (LibraryException e) {
			throw new LibraryException("Getting Error While Adding Book", e);
		}
		return customResponse;
	}
}
