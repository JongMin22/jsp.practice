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
	// DAO�ڵ� ��Ȱ���ϱ�.
	// 1. UserDAO���� �ּ�ó���� �� �� �κи� 
	// getInstance() �޼������ ������
	
	// 2. ~~~DAO�� �Ǿ��ִ� �κ��� ���� ���� DAOŬ���������� ����
	// ex) UserDAO -> BoardDAO�� ��ȯ���̹Ƿ� UserDAO��� ���� �κ��� ����  BoardDAO�� ����
	private DataSource ds = null;
	
	// ������ �� �ڵ����� Class.forName()�� �����ϰ� ����ϴ�.
		// public UserDAO() {
		// 	try {
		//		Class.forName(dbType);
		//		} catch(Exception e) {
		//		e.printStackTrace();
		//	}
		// }
		//  �̱��� ���� ó��.
		//  DAO ���ο� 3. ��������� UserDAO�� �ϳ� �������ݴϴ�.
		private static BoardDAO dao = new BoardDAO();
		//  �̱����� ��û�ø��� DAO�� ���� �������� �ʰ�, ���� �ϳ��� �����ص� ����
		//  ����� ��û���� �̹� ������ DAO�� �ּҰ��� �����ؼ�
		//  DAO������ �ʿ��� �ð��� �����ϱ� ���� ����մϴ�.
		//  1.�����ڴ� private���� ó���� �ܺο��� ��������� ���� �� ���� ó���մϴ�.
		private BoardDAO() {

		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		}	 
		catch (Exception e) {
			e.printStackTrace();
}
		}
		
		// 2. static Ű���带 �̿��ؼ� �� �ѹ��� �����ϰ�, �� ���ķδ�
		// �ּҸ� �����ϴ� getInstance �޼��带 ������ �ϴ�.
		public static BoardDAO getInstance() {
			if(dao == null) {
				dao = new BoardDAO();
			}
				
			return dao;
		}
		// 3. �ʿ�� �ϴ� ������ ������ �޼��带 �����ؿɴϴ�
		// �Խ��� �� ��ü��� �������� = > ȸ�� ��ü ��� �������⸦ �̿��� ����
		// ȸ�� ��ü ����� �������� getAllUserList�� ������ getAllBoardList()�� �����մϴ�.
		public List<BoardVO> getAllBoardList(){
			// try �� ���� �� Connection, PrepareStatement, ResultSet ����
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				List<BoardVO> boardList = new ArrayList<>();
			// Connection, PreparedStatement, ResultSet�� �����մϴ�.
				try {
					con = ds.getConnection();
				String sql = "SELECT * FROM boardinfo ORDER BY board_num DESC";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				//UserVO ArrayList�� rs�� �� ��� �ڷḦ �������ּ���.
				// int board_num, String title, String content, String writer, Date bdate, Date mdate, int hit
				// �ش� ������ �̿��� BoardVO�� �����ϸ� �˴ϴ�.
				while(rs.next()) {
				int boardNum = rs.getInt("board_num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date bdate = rs.getDate("bdate");
				Date mdate = rs.getDate("mdate");
				int hit = rs.getInt("hit");
				BoardVO boardData = new BoardVO(boardNum,title,content,writer,bdate,mdate,hit);
				boardList.add(boardData);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
				finally{
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
		
			String sql = "INSERT INTO boardinfo(title, content, writer) VALUE (?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, writer);
			pstmt.executeUpdate();
			}
			
			
			catch(Exception e) {
				e.printStackTrace();
				}
			finally{
				try {
				con.close();
				pstmt.close();
				
				} catch(Exception e) {
					e.printStackTrace();
				}
			}	
	}
		// �� �Ѱ��� �ʿ��� ��Ȳ�̹Ƿ� 
		// SELECT * FROM boradinfo WHERE board_num=?;
		public BoardVO getBoardDetail(int board_num) {
		// try �� ���� �� Connection, PrepareStatement, ResultSet ����
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			BoardVO board = null;
		// Connection, PreparedStatement, ResultSet�� �����մϴ�.
			try {
				con = ds.getConnection();
			String sql = "SELECT * FROM boardinfo WHERE board_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			rs = pstmt.executeQuery();
			
			//UserVO ArrayList�� rs�� �� ��� �ڷḦ �������ּ���.
			// int board_num, String title, String content, String writer, Date bdate, Date mdate, int hit
			// �ش� ������ �̿��� BoardVO�� �����ϸ� �˴ϴ�.
			if(rs.next()) {
			int boardNum = rs.getInt("board_num");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String writer = rs.getString("writer");
			Date bdate = rs.getDate("bdate");
			Date mdate = rs.getDate("mdate");
			int hit = rs.getInt("hit");
			board = new BoardVO(boardNum,title,content,writer,bdate,mdate,hit);
		
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
			finally{
				try {
				con.close();
				pstmt.close();
				rs.close();
				} catch(SQLException se) {
					se.printStackTrace();
				}
			}
		return board;
		}	

		// deleteBoard()�޼��带 ���� ����ó���� �ǰ� ������ֽð�
		// �������� �ش� �޼��带 ȣ���� ������ ������ư�� ������ DB���� �ش� ��ȣ ���� �����ǰ� ���ּ���.
		public void deleteBoard(int board_num) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
		
			try {
				con = ds.getConnection();
		
			String sql = "DELETE FROM boardinfo WHERE board_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			pstmt.executeUpdate();
			}
			
			
			catch(Exception e) {
				e.printStackTrace();
				}
			finally{
				try {
				con.close();
				pstmt.close();
				
				} catch(Exception e) {
					e.printStackTrace();
				}
			}	
	}
public void updateBoard(int board_num,String title, String content) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
		
			try {
				con = ds.getConnection();
		
			String sql = "UPDATES boardinfo SET title=?, content=?, mdate=now() WHERE board_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, board_num);
			pstmt.executeUpdate();
			}
			
			
			catch(Exception e) {
				e.printStackTrace();
				}
			finally{
				try {
				con.close();
				pstmt.close();
				
				} catch(Exception e) {
					e.printStackTrace();
				}
			}	
	}

		
}
