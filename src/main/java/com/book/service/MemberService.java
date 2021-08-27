package com.book.service;

import java.sql.Connection;

import com.book.dao.MemberDAO;
import com.book.vo.MemberVO;

import static com.book.db.JDBCUtility.*;
import static com.book.db.JDBCUtility.commit;
import static com.book.db.JDBCUtility.rollback;
public class MemberService {

	public boolean registMember(MemberVO member) {
		
		boolean isWriteSuccess = false;
		
		Connection conn = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		int insertCount = memberDAO.insertMember(member);

		if(insertCount>0) {
			commit(conn);
			isWriteSuccess = true;
		} else {
			rollback(conn);
		}
		
		return isWriteSuccess;
	}
	
	public MemberVO selectMember(String memId) {

		MemberVO member = new MemberVO();
		Connection conn = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		member = memberDAO.selectMember(memId);
		close(conn);
	
		return member; 	
	
	}
	
	public MemberVO loginMember(String memId,String memPw) {

		MemberVO member = new MemberVO();
		Connection conn = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		member = memberDAO.loginCheck(memId,memPw);
		
		close(conn);
	
		return member; 	
	
}

	public boolean modifyMember(MemberVO member) {
		
		boolean isWriteSuccess = false;
		
		Connection conn = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		int updateCount = memberDAO.modufyMember(member);

		if(updateCount>0) {
			commit(conn);
			isWriteSuccess = true;
		} else {
			rollback(conn);
		}
		
		return isWriteSuccess;
	}

	
	
	
	
}
