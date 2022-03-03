package kr.co.ict;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAO {
	//DAO Ŭ������ DB������ �����Ͽ� ó���մϴ�.

	//DB���ӿ� �ʿ��� �������� �Ʒ��� �����մϴ�.
	private String dbType = "com.mysql.cj.jdbc.Driver";
	private String dbUrl = "jdbc:mysql://localhost:3306/jdbcprac1"; 
	private String dbId = "root";
	private String dbPw = "mysql";
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
		private static UserDAO dao = new UserDAO();
		//  �̱����� ��û�ø��� DAO�� ���� �������� �ʰ�, ���� �ϳ��� �����ص� ����
		//  ����� ��û���� �̹� ������ DAO�� �ּҰ��� �����ؼ�
		//  DAO������ �ʿ��� �ð��� �����ϱ� ���� ����մϴ�.
		//  1.�����ڴ� private���� ó���� �ܺο��� ��������� ���� �� ���� ó���մϴ�.
		private UserDAO() {

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
		public static UserDAO getInstance() {
			if(dao == null) {
				dao = new UserDAO();
			}
				
			return dao;
		}
	// user_list2.jsp�� �ڵ� ������ ��ü�غ��ڽ��ϴ�.
	// user_list2.jsp���� ��ü ���� ����� �ʿ�� �ϱ� ������
	// ���� ����� List<UserVO>�� ��������� �մϴ�.
	// ���� SELECT������ �����Ҷ����� �����ڷᰡ �ʿ��ϰ�
	// INSERT, DELETE, UPDATE������ �����Ҷ��� �����ڷᰡ void�Դϴ�.
	public List<UserVO> getAllUserList(){
	// try �� ���� �� Connection, PrepareStatement, ResultSet ����
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserVO> userList = new ArrayList<>();
	// Connection, PreparedStatement, ResultSet�� �����մϴ�.
		try {
			con = ds.getConnection();
		String sql = "SELECT * FROM userinfo";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		//UserVO ArrayList�� rs�� �� ��� �ڷḦ �������ּ���.
		while(rs.next()) {
		String uName = rs.getString("uname");
		String uId = rs.getString("uid");
		String uPw = rs.getString("upw");
		String uEmail = rs.getString("uemail");
		UserVO userData = new UserVO(uName, uId, uPw, uEmail);
		userList.add(userData);
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
	return userList;
	}	
	
	
	// login_update.jsp�� ��� �α����� ���� �� ���� �����͸� DB���� ���ɴϴ�.
	// ����, �� �� ���� ���� �����͸��� �̿��� SELECT������ ����մϴ�.
	// login_update.jsp ����� sId ������ ����ִ� �������� �̿��� ���� �����͸� ���ɴϴ�.
	
	public UserVO getUserData(String sId) {
		// try �� ���� �� Connection, PrepareStatement, ResultSet ����
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				String tName =null;
				String tEmail=null;
				
			// Connection, PreparedStatement, ResultSet�� �����մϴ�.
				try {
					con = ds.getConnection();
				String sql = "SELECT * FROM userinfo WHERE uid=?";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				pstmt.setString(1, sId);
				if(rs.next()){ 
					 tName = rs.getString("uname");
					 tEmail = rs.getString("uemail");
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
			return null;
	}	 // DB���� UserVO�� �����͸� �������� null��� �޾ƿ� �����͸� �����ϼ���.
	public void updateCheck(String sId ,String uname, String upw, String uemail) {
		// Connection, PreparedStatement, ResultSet ���� ����
		Connection con = null;
		PreparedStatement pstmt = null;
		
	// try�� ���ο� DB����
		try {
			con = ds.getConnection();
	// �������� ������ rs�� DB���� ������ ������ �޾��ּ���.
		String sql = "UPDATE userinfo SET upw=?, uname=?, uemail=? WHERE uid =?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, upw);
		pstmt.setString(2, uname);
		pstmt.setString(3, uemail);
		pstmt.setString(4, sId);
		pstmt.executeUpdate();
		}
		
		// UserVO ������ �����ϰ�, rs�� ����� �����͸� UserVO�� ����ϴ�.
		catch(Exception e) {
			e.printStackTrace();
			}
			
							
		
	}

public void deleteUser(String sId) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
	
		try {
			con = ds.getConnection();
	
		String sql = "DELETE FROM userinfo WHERE uid =?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, sId);
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

	public void insertUser(String uId ,String uName, String uPw, String uEmail) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
	
		try {
			con = ds.getConnection();
	
		String sql = "INSERT INTO userinfo VALUES (?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, uName);
		pstmt.setString(2, uId);
		pstmt.setString(3, uPw);
		pstmt.setString(4, uEmail);
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

