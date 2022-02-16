package kr.co.ict;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	//DAO Ŭ������ DB������ �����Ͽ� ó���մϴ�.

	//DB���ӿ� �ʿ��� �������� �Ʒ��� �����մϴ�.
	private String dbType = "com.mysql.cj.jdbc.Driver";
	private String dbUrl = "jdbc:mysql://localhost:3306/jdbcprac1"; 
	private String dbId = "root";
	private String dbPw = "mysql";
	
	// ������ �� �ڵ����� Class.forName()�� �����ϰ� ����ϴ�.
	public UserDAO() {
		try {
			Class.forName(dbType);
			} catch(Exception e) {
			e.printStackTrace();
		}
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
		con = DriverManager.getConnection(dbUrl,dbId,dbPw);
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
				con = DriverManager.getConnection(dbUrl,dbId,dbPw);
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
	}

