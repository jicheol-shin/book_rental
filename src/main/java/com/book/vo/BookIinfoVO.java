package com.book.vo;

import java.util.Date;

public class BookIinfoVO {
	private String bookISBN;  /* SQLINES DEMO *** �번호 */
	private String groupCode; /* 분류기호 */
	private String writer;    /* 저자 */
	private String publisher; /* 출판사 */
	private Date   issueDate; /* 발행일 */
	private String bookName; /* 도서명 */
	private Date   incomingDate; /* 입고일 */
	
	
	
	
	
	public String getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Date getIncomingDate() {
		return incomingDate;
	}
	public void setIncomingDate(Date incomingDate) {
		this.incomingDate = incomingDate;
	}
	@Override
	public String toString() {
		return "book_info [bookISBN=" + bookISBN + ", groupCode=" + groupCode + ", writer=" + writer + ", publisher="
				+ publisher + ", issueDate=" + issueDate + ", bookName=" + bookName + ", incomingDate=" + incomingDate
				+ "]";
	}
	
	
	
	
	
}
