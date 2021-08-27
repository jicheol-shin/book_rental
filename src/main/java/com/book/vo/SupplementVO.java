package com.book.vo;

public class SupplementVO {

	private int supCode; /* 부록코드 */
	private int bookNum; /* 도서번호 */
	private String supName; /* 부록명 */
	
	public int getSupCode() {
		return supCode;
	}
	public void setSupCode(int supCode) {
		this.supCode = supCode;
	}
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public String getSupName() {
		return supName;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	
	
	@Override
	public String toString() {
		return "supplement [supCode=" + supCode + ", bookNum=" + bookNum + ", supName=" + supName + "]";
	}
	
	
	
	
	
}
