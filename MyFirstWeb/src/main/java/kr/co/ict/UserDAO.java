package kr.co.ict;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	//DAO 클래스는 DB연동을 전달하여 처리합니다.

	//DB접속에 필요한 변수들을 아래에 선언합니다.
	private String dbType = "com.mysql.cj.jdbc.Driver";
	private String dbUrl = "jdbc:mysql://localhost:3306/jdbcprac1"; 
	private String dbId = "root";
	private String dbPw = "mysql";
	
	// 생성할 때 자동으로 Class.forName()을 실행하게 만듭니다.
	public UserDAO() {
		try {
			Class.forName(dbType);
			} catch(Exception e) {
			e.printStackTrace();
		}
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
		con = DriverManager.getConnection(dbUrl,dbId,dbPw);
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
	}	 // DB에서 UserVO에 데이터를 받은다음 null대신 받아온 데이터를 리턴하세요.
	}

