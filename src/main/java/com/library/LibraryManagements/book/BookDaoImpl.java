package com.library.LibraryManagements.book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jongo.Jongo;
import org.springframework.stereotype.Component;

import com.library.LibraryManagements.bookvo.Book;
import com.library.LibraryManagements.constants.MongoCollectionConstants;
import com.library.LibraryManagements.constants.ResponseConstants;
import com.library.LibraryManagements.exception.LibraryException;
import com.library.LibraryManagements.mongodb.utils.MongoDBUtil;
import com.library.LibraryManagements.student.vo.Student;
import com.library.LibraryManagements.utils.CustomResponse;

@Component("bookDaoImpl")
public class BookDaoImpl implements BookDao{

	@Override
	public CustomResponse addBook(List<Book> book) throws LibraryException{
		CustomResponse customResponse=new CustomResponse();
		new Jongo(MongoDBUtil.getDB()).getCollection(MongoCollectionConstants.BOOK_BASE_DATA).insert(book.toArray());
		customResponse.setStatusCode(ResponseConstants.SUCCESS);
		customResponse.setStatusMessage(ResponseConstants.BOOK_ADDED);
		return customResponse;
	}

	@Override
	public List<Book> searchBookByName(String bookNamePattern) throws LibraryException{
		List<Book> bookList = new ArrayList<>();
		try {
			Iterator<Book> existingBook = new Jongo(MongoDBUtil.getDB())
					.getCollection(MongoCollectionConstants.BOOK_BASE_DATA)
					.find("{bookName:{$regex:#,$options:'i'}}", bookNamePattern).as(Book.class).iterator();
			while (existingBook.hasNext()) {
				Book book = existingBook.next();
				bookList.add(book);
			}
		} catch (LibraryException e) {
			throw new LibraryException("Getting Error While Searching Book By Name", e);
		}

		return bookList;
	}

	@Override
	public List<Book> searchBookByAuthorName(String authorNamePattern) throws LibraryException{
		List<Book> bookList = new ArrayList<>();
		try {
			Iterator<Book> existingBook = new Jongo(MongoDBUtil.getDB())
					.getCollection(MongoCollectionConstants.BOOK_BASE_DATA)
					.find("{authorName:{$regex:#,$options:'i'}}", authorNamePattern).as(Book.class).iterator();
			while (existingBook.hasNext()) {
				Book book = existingBook.next();
				bookList.add(book);
			}
		} catch (LibraryException e) {
			throw new LibraryException("Getting Error While Searching Book By Author Name", e);
		}

		return bookList;
	}

	@Override
	public List<BookCategory> getBookCategory() throws LibraryException{
		List<BookCategory> bookListCategory = new ArrayList<>();
		try {
			Iterator<BookCategory> existingBookCategory = new Jongo(MongoDBUtil.getDB())
					.getCollection(MongoCollectionConstants.BOOK_CATEGORY)
					.find("{}").as(BookCategory.class).iterator();
			while (existingBookCategory.hasNext()) {
				BookCategory bookCategory = existingBookCategory.next();
				bookListCategory.add(bookCategory);
			}
		} catch (LibraryException e) {
			throw new LibraryException("Getting Error While Searching Book By Author Name", e);
		}

		return bookListCategory;
	}

}
