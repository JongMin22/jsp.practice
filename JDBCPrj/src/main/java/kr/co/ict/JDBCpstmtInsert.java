package kr.co.ict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JDBCpstmtInsert {
	public static void main(String[] args) {
		String dbType = "com.mysql.cj.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/jdbcprac1"; 
		String dbId = "root";
		String dbPw = "mysql";
	 	try {
	 		Scanner scan = new Scanner(System.in);
	 		System.out.println("생성하고 싶은 아이디를 입력해주세요.");
	 		String uid = scan.nextLine();
	 		System.out.println("사용할 비밀번호를 입력해주세요.");
	 		String upw = scan.nextLine();
	 		System.out.println("사용할 이메일을 입력해주세요.");
	 		String uemail = scan.nextLine();
	 		System.out.println("사용할 이름을 입력해주세요.");
	 		String uname = scan.nextLine();
	 		Class.forName(dbType);
	 		Connection con = DriverManager.getConnection(dbUrl,dbId,dbPw);
	 		

			String sql= "INSERT INTO userinfo VALUES(?, ?, ?, ?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uname); 
			pstmt.setString(2, uid); 
			pstmt.setString(3, upw); 
			pstmt.setString(4, uemail); 
			pstmt.executeUpdate();
	 	}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
