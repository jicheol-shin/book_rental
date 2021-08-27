package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.book.vo.BoardVO;

import static com.book.db.JDBCUtility.*;

public class BoardDAO {

	private BoardDAO() {}
	private static BoardDAO boardDAO;
	public static BoardDAO getInstance() {
		if(boardDAO == null) boardDAO = new BoardDAO();
		return boardDAO;
	}

	Connection conn = null;
	DataSource ds = null;

	// DB커넥션
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	

	// 글갯수 구하기
	public int selectListCount() { 
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from board";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) listCount = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("게시글 갯수 가져오기 실패!! " + e.getMessage());
		} finally {
			close(pstmt, rs);
		}
		return listCount; 
	}
	
	// 글목록 조회
	public ArrayList<BoardVO> selectBoardList(int page, int limit) {
		
		ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
		BoardVO board = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from board order by board_re_ref desc, board_re_seq asc" +
		             " limit ?," + limit  ;
		int startRow = (page-1) * limit;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				board = new BoardVO();
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_name(rs.getString("board_name"));
				board.setBoard_subject(rs.getString("board_subject"));
				board.setBoard_content(rs.getString("board_content"));
				board.setBoard_file(rs.getString("board_file"));
				board.setBoard_re_ref(rs.getInt("board_re_ref"));
				board.setBoard_re_lev(rs.getInt("board_re_lev"));
				board.setBoard_re_seq(rs.getInt("board_re_seq"));
				board.setBoard_readcount(rs.getInt("board_readcount"));
				board.setBoard_date(rs.getDate("board_date"));
				boardList.add(board);
			}

		} catch (SQLException e) {
			System.out.println("게시글 조회 실패 :" + e.getMessage());
		} finally {
			close(pstmt, rs);
		}
		
		return boardList; 
	}
	
	// 글내용 보기
	public BoardVO selectBoard(int board_num) {
		
		BoardVO board = new BoardVO();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from board where board_num = " + board_num;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
	
			if(rs.next()) {
				board = new BoardVO();
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_name(rs.getString("board_name"));
				board.setBoard_subject(rs.getString("board_subject"));
				board.setBoard_content(rs.getString("board_content"));
				board.setBoard_file(rs.getString("board_file"));
				board.setBoard_re_ref(rs.getInt("board_re_ref"));
				board.setBoard_re_lev(rs.getInt("board_re_lev"));
				board.setBoard_re_seq(rs.getInt("board_re_seq"));
				board.setBoard_readcount(rs.getInt("board_readcount"));
				board.setBoard_date(rs.getDate("board_date"));
			 }
		} catch (Exception e) {
			System.out.println("게시글 조회 실패!! " + e.getMessage());
		} finally {
			close(pstmt, rs);
		}
		
		return board; 
	}
	
	// 글쓰기
	public int insertBoard(BoardVO board) { 
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into board(board_num, board_name, board_pass, board_subject, " +
				" board_content, board_file, board_re_ref, board_re_lev, board_re_seq, board_readcount, board_date ) " +
				" values(?,?,?,?,?,?,?,?,?,?,now())";
		int insertCount = 0;
		int num = 0;
		
		try {
			pstmt = conn.prepareStatement("select max(board_num) from board");
			rs = pstmt.executeQuery();
			if(rs.next()) num = rs.getInt(1) + 1; else num = 1;
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, board.getBoard_name());
			pstmt.setString(3, board.getBoard_pass());
			pstmt.setString(4, board.getBoard_subject());
			pstmt.setString(5, board.getBoard_content());
			pstmt.setString(6, board.getBoard_file());
			pstmt.setInt(7, num);
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 0);
			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시글 등록 실패!! " + e);
		} finally {
			close(pstmt, rs);
		}
		return insertCount; 	
	}
	
	// 글답변
	public int insertReplyBoard(BoardVO board) { 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update board set board_re_seq= board_re_seq + 1 " + 
				     " where board_re_ref = ? and board_re_seq > ?";
		int num = 0;
		int insertCount = 0;
		int re_ref = board.getBoard_re_ref();
		int re_lev = board.getBoard_re_lev();
		int re_seq = board.getBoard_re_seq();
		
		try {
			pstmt = conn.prepareStatement("select max(board_num)+1 from board");
			rs = pstmt.executeQuery();
			if(rs.next()) num = rs.getInt(1); else num = 1;
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, re_ref);
			pstmt.setInt(2, re_seq);
			int updateCount = pstmt.executeUpdate();
			if(updateCount>0) commit(conn);
			
			re_seq = re_seq + 1;
			re_lev = re_lev + 1;
					
			sql = "insert into board(board_num, board_name, board_pass, board_subject, " +
					" board_content, board_file, board_re_ref, board_re_lev, board_re_seq, board_readcount, board_date ) " +
					" values(?,?,?,?,?,?,?,?,?,?,now())";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.setString(2, board.getBoard_name());
				pstmt.setString(3, board.getBoard_pass());
				pstmt.setString(4, board.getBoard_subject());
				pstmt.setString(5, board.getBoard_content());
				pstmt.setString(6, "");
				pstmt.setInt(7, re_ref);
				pstmt.setInt(8, re_lev);
				pstmt.setInt(9, re_seq);
				pstmt.setInt(10, 0);
				insertCount = pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("게시글 등록 실패!! " + e);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			close(pstmt, rs);
		}

	 	return insertCount;
		
	}
	
	// 글수정
	public int updateBoard(BoardVO board) {
		int updateCount=0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update board set board_subject = ?, board_content = ?" + 
				     " where board_num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoard_subject());
			pstmt.setString(2, board.getBoard_content());
			pstmt.setInt(3, board.getBoard_num());
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("게시글 수정실패 !!" + e.getMessage());
		} finally {
			close(pstmt,rs);
		}
		
		return updateCount; 
	}
	
	// 글삭제
	public int deleteBoard(int board_num) { 
		int deleteCount = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from board  where board_num = " + board_num;
		
		try {
			pstmt = conn.prepareStatement(sql);
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("게시글 삭제 실패 !!" + e.getMessage());
		} finally {
			close(pstmt);
		}
		
		return deleteCount; 
	}
	
	// 조회수
	public int updateReadCount(int board_num) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql ="update board set board_readcount = board_readcount + 1"+
		        " where board_num = " + board_num;
		try {
			pstmt = conn.prepareStatement(sql);
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("게시글 조회실패 !!" + e.getMessage());
		} finally {
			close(pstmt);
		}
		
    	return updateCount; 
    }
	
	// 글작성자확인
	public boolean isBoardWriter(int board_num, String pass) { 
		boolean isWriter = false;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		String sql = "select * from board where board_num = " + board_num ;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			if(pass.equals(rs.getString("board_pass"))) isWriter = true;
			
		} catch (SQLException e) {
			System.out.println("게시글을 조회하지 못했습니다!! 확인해주세요!!" + e.getMessage());
			
		} finally {
			close(pstmt,rs);
		}
		System.out.println();
		return isWriter; 
	}
}




















