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
				String sql = "SELECT * FROM boardinfo";
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
}
