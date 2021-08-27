package com.book.vo;

import java.util.Date;

public class MemberVO {
	
	private int num;    // 순번
	private String memId;    // 아이디
	private String memPw;    /* 패스워드 */
	private String memName;  /* 이름 */	
	private String memTel;   /* 전화번호 */
	private String memEmail;  /* 이메일 */
	private String memAddr1;  /* 도로명 주소 */
	private String memAddr2;  /* 세부주소 */
	private String gender;    
	private Date   registDate; /* 가입일 */
	private Date   dormantDate; /* 휴면전환일 */
	private String gradeCode;
		
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	
	public String getMemAddr1() {
		return memAddr1;
	}
	public void setMemAddr1(String memAddr1) {
		this.memAddr1 = memAddr1;
	}
	public String getMemAddr2() {
		return memAddr2;
	}
	public void setMemAddr2(String memAddr2) {
		this.memAddr2 = memAddr2;
	}
	public String getMemTel() {
		return memTel;
	}
	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public Date getDormantDate() {
		return dormantDate;
	}
	public void setDormantDate(Date dormantDate) {
		this.dormantDate = dormantDate;
	}
	public String getGradeCode() {
		return gradeCode;
	}
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	
	
}
