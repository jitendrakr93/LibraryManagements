package com.library.LibraryManagements.bookvo;

public class Book {
	private long bookId;
	private String bookName;
	private String authorName;
	private String bookMasterType;
	private String bookCategoryName;
	private double perUnitPrice;
	private int bookQuantity;
	private boolean issuedStatus;
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getBookMasterType() {
		return bookMasterType;
	}
	public void setBookMasterType(String bookMasterType) {
		this.bookMasterType = bookMasterType;
	}
	public String getBookCategoryName() {
		return bookCategoryName;
	}
	public void setBookCategoryName(String bookCategoryName) {
		this.bookCategoryName = bookCategoryName;
	}
	public double getPerUnitPrice() {
		return perUnitPrice;
	}
	public void setPerUnitPrice(double perUnitPrice) {
		this.perUnitPrice = perUnitPrice;
	}
	public int getBookQuantity() {
		return bookQuantity;
	}
	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}
	public boolean isIssuedStatus() {
		return issuedStatus;
	}
	public void setIssuedStatus(boolean issuedStatus) {
		this.issuedStatus = issuedStatus;
	}
	

}
