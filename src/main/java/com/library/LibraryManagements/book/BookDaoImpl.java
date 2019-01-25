package com.library.LibraryManagements.book;

import java.util.List;

import org.jongo.Jongo;
import org.springframework.stereotype.Component;

import com.library.LibraryManagements.bookvo.Book;
import com.library.LibraryManagements.constants.MongoCollectionConstants;
import com.library.LibraryManagements.constants.ResponseConstants;
import com.library.LibraryManagements.mongodb.utils.MongoDBUtil;
import com.library.LibraryManagements.utils.CustomResponse;

@Component("bookDaoImpl")
public class BookDaoImpl implements BookDao{

	@Override
	public CustomResponse addBook(List<Book> book) {
		CustomResponse customResponse=new CustomResponse();
		new Jongo(MongoDBUtil.getDB()).getCollection(MongoCollectionConstants.BOOK_BASE_DATA).insert(book.toArray());
		customResponse.setStatusCode(ResponseConstants.SUCCESS);
		customResponse.setStatusMessage(ResponseConstants.BOOK_ADDED);
		return customResponse;
	}

}
