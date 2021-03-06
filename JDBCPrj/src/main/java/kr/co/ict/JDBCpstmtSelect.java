package kr.co.ict;

import java.sql.*;
import java.util.Scanner;


public class JDBCpstmtSelect {
	public static void main(String[] args) {
		// DB지정, 연결까지 직접 해보세요
		// DB종류, 스키마주소. 계정명, 비번은 변수로 관리합니다.
		String dbname = "com.mysql.cj.jdbc.Driver";
		String dburl = "jdbc:mysql://localhost:3306/jdbcprac1"; 
		String dbid = "root";
		String dbpw = "mysql";
	 	try {
	 		// 사용자한테 조회할 아이디 입력받기
	 		Scanner scan = new Scanner(System.in);
	 		System.out.println("조회하고 싶은 아이디를 입력해주세요.");
	 		String uid = scan.nextLine();
	 		// DB종류 지정
			Class.forName(dbname);
			// DB연결
			Connection con = DriverManager.getConnection(dburl, // 접속 url
														dbid, //  mysql 아이디 
														dbpw);// mysql 비밀번호
			// 3.PreparedStatement구문은 먼버 SQL쿼리문을 만들어놓고 적용합니다.
			// 중간에 사용자 입력 정보를 받는 부분을 전부 ? 로만 치환해서 지정합니다.
			// ?는 2개 이상 쓸 수도 있습니다.
			String sql= "SELECT * FROM userinfo WHERE uid=?";
			
			// pstmt 변수를 만들어 세팅합니다
			PreparedStatement pstmt = con.prepareStatement(sql);
			// ?에 들어갈 자료를 정의해줍니다.
			pstmt.setString(1, uid); // 29번라인 1번 ? 자리에 uid를 넣어주겠다는 의미
			// 4. 쿼리문 실행
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
			}
			
	 	}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
