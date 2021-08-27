package com.book.vo;

public class MemberGradeVO {

	private String gradeCode;  /* 등급코드 */
	private String gradeName; /* 등급명 */
	
	
	
	public String getGradeCode() {
		return gradeCode;
	}
	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	@Override
	public String toString() {
		return "member_grade [gradeCode=" + gradeCode + ", gradeName=" + gradeName + "]";
	}
	
	
	
	
	
}
