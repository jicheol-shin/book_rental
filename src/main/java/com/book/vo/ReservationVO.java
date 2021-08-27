package com.book.vo;

import java.util.Date;

public class ReservationVO {
	
	private String MemId; /* 회원아이디 */
	private int bookNum; /* 도서번호 */
	private Date resverveDate; /* 예약일시 */
	
	
	public String getMemId() {
		return MemId;
	}
	public void setMemId(String memId) {
		MemId = memId;
	}
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public Date getResverveDate() {
		return resverveDate;
	}
	public void setResverveDate(Date resverveDate) {
		this.resverveDate = resverveDate;
	}

	
	@Override
	public String toString() {
		return "reservation [MemId=" + MemId + ", bookNum=" + bookNum + ", resverveDate=" + resverveDate + "]";
	}
	
	
	
	
}
