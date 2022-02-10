package kr.co.ict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCUpdate {
public static void main(String[] args) {
	
	// UPDATE구문도 처리해주세요.
	// UPDATE는 id는 변경하지 않습니다.
	// 어떤 아이디의 pw, name, email을 변경할지 조회하기 위해
	// 먼저 id를 받고, 그 다음 
	// pw, name, email을 받아서
	// UPDATE구문에서 조건절에 id를 넣어 타겟을 정하고 
	// 나머지 항목만 수정되도록 처리해주세요.
	String dbname = "com.mysql.cj.jdbc.Driver";
	String dburl = "jdbc:mysql://localhost:3306/jdbcprac1"; 
	String dbid = "root";
	String dbpw = "mysql";
 	try {
		Class.forName(dbname);
		Connection con = DriverManager.getConnection(dburl, // 접속 url
													dbid, //  mysql 아이디 
													dbpw);// mysql 비밀번호
 
	
		Statement stmt = con.createStatement();
		Scanner scan = new Scanner(System.in);
		System.out.println("업데이트할 아이디를 입력해주세요");
		String uid = scan.nextLine();
		//  UPDATE users SET pw='aaa' WHERE id ='aaa';
		System.out.println("변경할 비밀번호를 입력해주세요.");
		String upw = scan.nextLine();
		System.out.println("변경할 이름를 입력해주세요.");
		String uname = scan.nextLine();
		System.out.println("변경할 이메일를 입력해주세요.");
		String uemail = scan.nextLine();
		System.out.println("쿼리문 디버깅 작업");
		System.out.println("UPDATE userinfo SET upw ='"+upw+"', uname='"+uname+"', uemail='"+uemail+"' WHERE uid ='"+uid+"'");
		stmt.executeUpdate("UPDATE userinfo SET upw ='"+upw+"', uname='"+uname+"', uemail='"+uemail+"' WHERE uid ='"+uid+"'");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
	
}

