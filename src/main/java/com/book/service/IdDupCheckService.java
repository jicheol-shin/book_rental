package com.book.service;

import static com.book.db.JDBCUtility.commit;
import static com.book.db.JDBCUtility.getConnection;
import static com.book.db.JDBCUtility.rollback;
import java.sql.Connection;
import com.book.dao.MemberDAO;

public class IdDupCheckService {
	
	public int IdDuplicationCheck(String memId) {
		int id_num = 0;
		Connection conn = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		id_num = memberDAO.idDupCheck(memId);
		
		if(id_num>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return id_num;
	}
	
	

}
