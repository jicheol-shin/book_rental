package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.book.vo.MemberVO;

import static com.book.db.JDBCUtility.*;


public class MemberDAO {

	private MemberDAO() {}
	private static MemberDAO memberDAO;
	public static MemberDAO getInstance() {
		if(memberDAO == null) memberDAO = new MemberDAO();
		return memberDAO;
	}

	Connection conn = null;
	DataSource ds = null;

	// DB커넥션
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	// 회원등록
	public int insertMember(MemberVO member) { 
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "insert into member(num,mem_id, mem_pw, mem_name, mem_tel, " +
					" mem_email, mem_addr1,mem_addr1, gender, regist_date ) " +
					" values(?,?,?,?,?,?,?,?,?,now())";
			int insertCount = 0;
			int num = 0;
			
			try {
				pstmt = conn.prepareStatement("select max(num) from member");
				rs = pstmt.executeQuery();
				if(rs.next()) num = rs.getInt(1) + 1; else num = 1;
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.setString(2, member.getMemId());
				pstmt.setString(3, member.getMemPw());
				pstmt.setString(4, member.getMemName());
				pstmt.setString(5, member.getMemTel());
				pstmt.setString(6, member.getMemEmail());
				pstmt.setString(7, member.getMemAddr1());
				pstmt.setString(8, member.getMemAddr2());
				pstmt.setString(9, member.getGender());
				insertCount = pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("회원가입 실패!! " + e);
			} finally {
				close(pstmt, rs);
			}
			return insertCount; 	
		}
	
		// 회원조회
		public MemberVO selectMember(String memId) {
			
			MemberVO member = new MemberVO();
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select * from member where mem_id = '" + memId +"'";
			
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
		
				if(rs.next()) {
					member.setMemId(rs.getString("mem_id"));
					member.setMemName(rs.getString("mem_name"));
					member.setMemPw(rs.getString("mem_pw"));
					member.setMemTel(rs.getString("mem_tel"));
					member.setMemEmail(rs.getString("mem_email"));
					member.setMemAddr1(rs.getString("mem_addr1"));
					member.setMemAddr2(rs.getString("mem_addr2"));
					member.setGender(rs.getString("gender"));
					member.setRegistDate(rs.getDate("regist_date"));
				 }
			} catch (Exception e) {
				System.out.println("회원 조회 실패!! " + e.getMessage());
			} finally {
				close(pstmt, rs);
			}
			
			return member; 
		}	
	
		// idCheck
		public int idDupCheck(String memId) {
			
			int id_num = 0;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select count(*) from member where mem_id = ?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memId);
				rs = pstmt.executeQuery();
				if(rs.next()) id_num = rs.getInt(1);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt, rs);
			}
			return id_num; 
		}
	
		// 로그인
		public MemberVO loginCheck(String memId, String memPw) {
			
			MemberVO member = new MemberVO();
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select * from member where mem_id = ? and mem_pw = ?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memId);
				pstmt.setString(2, memPw);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					member.setNum(rs.getInt("num"));
					member.setMemId(rs.getString("mem_id"));
					member.setMemName(rs.getString("mem_name"));
					member.setMemPw(rs.getString("mem_pw"));
					member.setMemTel(rs.getString("mem_tel"));
					member.setMemEmail(rs.getString("mem_email"));
					member.setMemAddr1(rs.getString("mem_addr1"));
					member.setMemAddr2(rs.getString("mem_addr2"));
					member.setGender(rs.getString("gender"));
					member.setRegistDate(rs.getDate("regist_date"));
					member.setGradeCode(rs.getString("grade_code"));
				 }
				
			} catch (Exception e) {
				System.out.println("회원 아이디나 패스워드를 확인해 주세요!! " + e.getMessage());
			} finally {
				close(pstmt, rs);
			}
			
			return member; 
		}

		public int modufyMember(MemberVO member) {

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int updateCount = 0;
			String pw =  member.getMemPw();

			if (!pw.equals("")) {
					
				String sql = "update member set mem_pw =?, mem_name=?, mem_tel=?, " +
						     " mem_email = ? , mem_addr1 = ?, mem_addr2 = ?, gender = ? " +
							 " where Mem_id = ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, member.getMemPw());
					pstmt.setString(2, member.getMemName());
					pstmt.setString(3, member.getMemTel());
					pstmt.setString(4, member.getMemEmail());
					pstmt.setString(5, member.getMemAddr1());
					pstmt.setString(6, member.getMemAddr2());
					pstmt.setString(7, member.getGender());
					pstmt.setString(8, member.getMemId());
					updateCount = pstmt.executeUpdate();
					
				} catch (Exception e) {
					System.out.println("회원정보 수정 실패!! " + e);
				} finally {
					close(pstmt, rs);
				}
			} else {
				String sql = "update member set mem_name=?, mem_tel=?, " +
					     " mem_email = ? , mem_addr1 = ?, mem_addr2 = ?, gender = ? " +
						 " where Mem_id = ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, member.getMemName());
					pstmt.setString(2, member.getMemTel());
					pstmt.setString(3, member.getMemEmail());
					pstmt.setString(4, member.getMemAddr1());
					pstmt.setString(5, member.getMemAddr2());
					pstmt.setString(6, member.getGender());
					pstmt.setString(7, member.getMemId());
					
					updateCount = pstmt.executeUpdate();
					
				} catch (Exception e) {
					System.out.println("회원정보 수정 실패!! " + e);
				} finally {
					close(pstmt, rs);
				}
			}
			return updateCount; 	
		}
	
}
