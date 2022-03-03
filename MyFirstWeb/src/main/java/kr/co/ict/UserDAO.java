package kr.co.ict;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAO {
	//DAO 클래스는 DB연동을 전달하여 처리합니다.

	//DB접속에 필요한 변수들을 아래에 선언합니다.
	private String dbType = "com.mysql.cj.jdbc.Driver";
	private String dbUrl = "jdbc:mysql://localhost:3306/jdbcprac1"; 
	private String dbId = "root";
	private String dbPw = "mysql";
	private DataSource ds = null;
	
	// 생성할 때 자동으로 Class.forName()을 실행하게 만듭니다.
		// public UserDAO() {
		// 	try {
		//		Class.forName(dbType);
		//		} catch(Exception e) {
		//		e.printStackTrace();
		//	}
		// }
		//  싱글턴 패턴 처리.
		//  DAO 내부에 3. 멤버변수로 UserDAO를 하나 생성해줍니다.
		private static UserDAO dao = new UserDAO();
		//  싱글턴은 요청시마다 DAO를 새로 생성하지 않고, 먼저 하나를 생성해둔 다음
		//  사용자 요청때는 이미 생성된 DAO의 주소값만 공유해서
		//  DAO생성에 필요한 시간을 절약하기 위해 사용합니다.
		//  1.생성자는 private으로 처리해 외부에서 생성명령을 내릴 수 없게 처리합니다.
		private UserDAO() {

		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		}	 
		catch (Exception e) {
			e.printStackTrace();
}
		}
		
		// 2. static 키워드를 이용해서 단 한번만 생성하고, 그 이후로는
		// 주소를 공유하는 getInstance 메서드를 생성합 니다.
		public static UserDAO getInstance() {
			if(dao == null) {
				dao = new UserDAO();
			}
				
			return dao;
		}
	// user_list2.jsp의 코드 로직을 대체해보겠습니다.
	// user_list2.jsp에서 전체 유저 목록을 필요로 하기 때문에
	// 실행 결과로 List<UserVO>를 리턴해줘야 합니다.
	// 역시 SELECT구문을 실행할때에는 리턴자료가 필요하고
	// INSERT, DELETE, UPDATE구문을 실행할때는 리턴자료가 void입니다.
	public List<UserVO> getAllUserList(){
	// try 블럭 진입 전 Connection, PrepareStatement, ResultSet 선언
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserVO> userList = new ArrayList<>();
	// Connection, PreparedStatement, ResultSet을 선언합니다.
		try {
			con = ds.getConnection();
		String sql = "SELECT * FROM userinfo";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		//UserVO ArrayList에 rs에 든 모든 자료를 저장해주세요.
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
	
	
	// login_update.jsp의 경우 로그인한 유저 한 명의 데이터만 DB에서 얻어옵니다.
	// 따라서, 그 한 명의 유저 데이터만을 이용해 SELECT구문을 써야합니다.
	// login_update.jsp 상단의 sId 변수에 들어있는 유저명을 이용해 유저 데이터를 얻어옵니다.
	
	public UserVO getUserData(String sId) {
		// try 블럭 진입 전 Connection, PrepareStatement, ResultSet 선언
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				String tName =null;
				String tEmail=null;
				
			// Connection, PreparedStatement, ResultSet을 선언합니다.
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
	}	 // DB에서 UserVO에 데이터를 받은다음 null대신 받아온 데이터를 리턴하세요.
	public void updateCheck(String sId ,String uname, String upw, String uemail) {
		// Connection, PreparedStatement, ResultSet 변수 선언
		Connection con = null;
		PreparedStatement pstmt = null;
		
	// try블럭 내부에 DB연결
		try {
			con = ds.getConnection();
	// 쿼리문을 날려서 rs에 DB에서 가져온 정보를 받아주세요.
		String sql = "UPDATE userinfo SET upw=?, uname=?, uemail=? WHERE uid =?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, upw);
		pstmt.setString(2, uname);
		pstmt.setString(3, uemail);
		pstmt.setString(4, sId);
		pstmt.executeUpdate();
		}
		
		// UserVO 변수를 선언하고, rs에 저장된 데이터를 UserVO에 담습니다.
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

