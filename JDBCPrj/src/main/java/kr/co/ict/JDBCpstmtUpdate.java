package kr.co.ict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JDBCpstmtUpdate {
	public static void main(String[] args) {
		String dbType = "com.mysql.cj.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/jdbcprac1"; 
		String dbId = "root";
		String dbPw = "mysql";
	 	try {
	 		Scanner scan = new Scanner(System.in);
	 		System.out.println("업데이트할 아이디를 입력해주세요.");
	 		String uid = scan.nextLine();
	 		System.out.println("새로 사용할 비밀번호를 입력해주세요.");
	 		String upw = scan.nextLine();
	 		System.out.println("새로 사용할 이메일을 입력해주세요.");
	 		String uemail = scan.nextLine();
	 		System.out.println("새로 사용할 이름을 입력해주세요.");
	 		String uname = scan.nextLine();
	 		Class.forName(dbType);
	 		Connection con = DriverManager.getConnection(dbUrl,dbId,dbPw);
	 		

			String sql= "UPDATE userinfo SET uname=?, upw=?, uemail=? WHERE uid=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, uname); 
			pstmt.setString(2, upw); 
			pstmt.setString(3, uemail);
			pstmt.setString(4, uid);
			pstmt.executeUpdate();
			
			// .close()로 열린 자료 닫기
			// 일반 자바코드는 어차피 코드실행이 끝나면 프로그램이 강제로 종료되지만
			// 서버의 경우는 코드실행이 끝나도 서버가 계속 돌아가 자원회수를 안 해주면 점점 시스템에 부하가 걸릴수도 있음.
			// 이를 막기 위해 호출이 끝난 자원은 .close()로 사용해제를 해 줘야 함.
			
			con.close();
			pstmt.close();
			scan.close();
			
	 	}
		catch(Exception e) {
			e.printStackTrace();
		}
	 	finally {
	 		// 종료구문안내  + .close()로 열린 자료 닫기
	 		System.out.println("수정완료");
	 	}
		
	}

}
