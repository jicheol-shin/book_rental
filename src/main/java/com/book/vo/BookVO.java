package com.book.vo;

public class BookVO {
	
	private int bookNum; /* 도서번호 */
	private String bookISBN; /* SQLINES DEMO *** �번호 */
	private String bookRentalY; /* 대출여부 */
	private String bookReserveYN; /* 예약여부 */
	
	
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}
	public String getBookRentalY() {
		return bookRentalY;
	}
	public void setBookRentalY(String bookRentalY) {
		this.bookRentalY = bookRentalY;
	}
	public String getBookReserveYN() {
		return bookReserveYN;
	}
	public void setBookReserveYN(String bookReserveYN) {
		this.bookReserveYN = bookReserveYN;
	}
	@Override
	public String toString() {
		return "book [bookNum=" + bookNum + ", bookISBN=" + bookISBN + ", bookRentalY=" + bookRentalY
				+ ", bookReserveYN=" + bookReserveYN + "]";
	}
	
	
	
	
	
	
	
}
