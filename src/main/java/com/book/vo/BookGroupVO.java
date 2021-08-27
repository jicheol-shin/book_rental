package com.book.vo;

public class BookGroupVO {

	private String groupCode; /* 분류기호 */
	private String groupName; /* 분류명 */
	
	
	
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	@Override
	public String toString() {
		return "book_group [groupCode=" + groupCode + ", groupName=" + groupName + "]";
	}
	
	
	
}
