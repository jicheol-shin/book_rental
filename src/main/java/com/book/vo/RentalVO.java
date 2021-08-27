package com.book.vo;

import java.util.Date;

public class RentalVO {
	
	private int renNum; /* 대여번호 */
	private int bookNum; /* 도서번호 */
	private String memId; /* 회원아이디 */
	private Date rentalDate; /* 대출일자 */
	private Date returnDate; /* 반납일자 */
	private String supRenYN; /* SQLINES DEMO *** � */
	private int supCode; /* 부록코드 */
	private Date renewalDate; /* 대출연장일 */
	
	
	public int getRenNum() {
		return renNum;
	}
	public void setRenNum(int renNum) {
		this.renNum = renNum;
	}
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
		
	public Date getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public String getSupRenYN() {
		return supRenYN;
	}
	public void setSupRenYN(String supRenYN) {
		this.supRenYN = supRenYN;
	}
	public int getSupCode() {
		return supCode;
	}
	public void setSupCode(int supCode) {
		this.supCode = supCode;
	}
	public Date getRenewalDate() {
		return renewalDate;
	}
	public void setRenewalDate(Date renewalDate) {
		this.renewalDate = renewalDate;
	}
	
	
	@Override
	public String toString() {
		return "rental [renNum=" + renNum + ", bookNum=" + bookNum + ", memId=" + memId + ", rentalDate=" + rentalDate
				+ ", returnDate=" + returnDate + ", supRenYN=" + supRenYN + ", supCode=" + supCode + ", renewalDate="
				+ renewalDate + "]";
	}
	
	
	
	
}
