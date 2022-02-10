package kr.co.ict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDelete {
	public static void main(String[] args) {
		
		// 사용자가 Scanner로 아이디를 입력하면
		// 해당 아이디 정보가 DB에서 삭제되도록 로직을 작성해보세요.
		// 역시 executeUpdate("실행문"); 으로 실행합니다.
		// Insert에서 시범 보여드렸듯 실행 전에 콘솔을 이용해서
		// 쿼리문이 제데로 작성되었는지 확인할 수 있도록 보여주는 코드도
		// 같이 작성해주세여.
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprac1", // 접속 url
														"root", //  mysql 아이디 
														"mysql");// mysql 비밀번호
	 
		
			Statement stmt = con.createStatement();
			Scanner scan = new Scanner(System.in);
			System.out.println("삭제할 아이디를 입력해주세요");
			String uid = scan.nextLine();
			
			System.out.println("쿼리문 디버깅 작업");
			System.out.println("DELETE FROM userinfo WHERE uid ='"+uid+"'");
			stmt.executeUpdate("DELETE FROM userinfo WHERE uid ='"+uid+"'");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
