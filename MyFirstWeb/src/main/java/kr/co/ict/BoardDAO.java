package kr.co.ict;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {


	private DataSource ds = null;
	
	private static BoardDAO dao = new BoardDAO();
	
	private BoardDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	
	
	public List<BoardVO> getAllBoardList(){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BoardVO> boardList = new ArrayList<>();
		try {
			
			con = ds.getConnection();
			
			
			String sql = "SELECT * FROM boardtbl ORDER BY board_num DESC";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

		
			while(rs.next()) {
				
				int boardNum = rs.getInt("board_num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date bDate = rs.getDate("bdate");
				Date mDate = rs.getDate("mdate");
				int hit = rs.getInt("hit");
				
				BoardVO boardData = new BoardVO(boardNum, title, content, writer, bDate, mDate, hit);
				boardList.add(boardData);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}	
		return boardList;
	}
	

	public void insertBoard(String title, String content, String writer) {
	
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
			con = ds.getConnection();
			
			
			String sql = "INSERT INTO boardTbl(title, content, writer) VALUES (?, ?, ?)";
			pstmt = con.prepareStatement(sql);
		
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, writer);
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}	
	}

	
	// SELECT * FROM boardTbl WHERE board_num = ?
	public BoardVO getBoardDetail(int board_num) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO board = null;
		try {
			con = ds.getConnection();
			String sql = "SELECT * FROM boardTbl WHERE board_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int boardNum = rs.getInt("board_num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date bDate = rs.getDate("bdate");
				Date mDate = rs.getDate("mdate");
				int hit = rs.getInt("hit");
				
				board = new BoardVO(boardNum, title, content, writer, bDate, mDate, hit);
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return board;	
	}
	

	public void deleteBoard(int boardNum) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
			con = ds.getConnection();

			String sql = "DELETE FROM boardTbl WHERE board_num=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, boardNum);

			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}	
	}
	public void boardUpdate(String title, String content, int bNum) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
			con = ds.getConnection();

			String sql = "UPDATE boardTbl SET title=?, content=?, mdate=now() WHERE board_num=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, bNum);

		
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}	
	}
}






