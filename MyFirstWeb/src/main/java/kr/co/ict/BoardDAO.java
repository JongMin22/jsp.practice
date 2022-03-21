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
	
	
	public List<BoardVO> getAllBoardList(int pageNum){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BoardVO> boardList = new ArrayList<>();
		try {
			
			con = ds.getConnection();
			int limitNum = ((pageNum - 1)* 20);
			
			String sql = "SELECT * FROM boardtbl ORDER BY board_num DESC limit ?, 20";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, limitNum);
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
	// uphit 미포함
	public BoardVO getBoardDetail2(int board_num) {
		
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
	// 서비스가 아닌 getBoardDetail 실행시 자동으로 같이 실행되도록 처리
	// 글 제목을 클릭할때마다 조회수를 증가시키는 메서드
	public void uphit(int bId){
		// update문에 맞는 접속 로직을 작성해주세요.
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
			con = ds.getConnection();

			String sql = "UPDATE boardtbl SET hit = (hit + 1) WHERE board_num=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bId);
			

		
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
	// 페이징 처리를 위해 글 전체 개수를 구해오겠습니다.
	// 하단에 getPageNum()을 작성해주세요
	// 쿼리문은 SELECT COUNT(*) FROM boardTbl; 입니다.
	
public int getPageNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int pageNum = 0;	
		
		
		try {
			con = ds.getConnection();
			String sql = "SELECT COUNT(*) FROM boardTbl";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pageNum = rs.getInt(1);
				
				
				
				
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
		return pageNum;	
	}
}






