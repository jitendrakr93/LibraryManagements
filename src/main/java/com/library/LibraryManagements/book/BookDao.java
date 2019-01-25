package com.library.LibraryManagements.book;

import java.util.List;

import com.library.LibraryManagements.bookvo.Book;
import com.library.LibraryManagements.utils.CustomResponse;

public interface BookDao {

	CustomResponse addBook(List<Book> book);

}
