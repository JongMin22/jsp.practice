package kr.co.ict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JDBCpsmtDelete {
	public static void main(String[] args) {
		String dbname = "com.mysql.cj.jdbc.Driver";
		String dburl = "jdbc:mysql://localhost:3306/jdbcprac1"; 
		String dbid = "root";
		String dbpw = "mysql";
	 	try {
	 		Scanner scan = new Scanner(System.in);
	 		System.out.println("�����ϰ� ���� ���̵� �Է����ּ���.");
	 		String uid = scan.nextLine();
	 		Class.forName(dbname);
	 		Connection con = DriverManager.getConnection(dburl,dbid,dbpw);
	 		

			String sql= "DELETE FROM userinfo WHERE uid=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uid); 
			pstmt.executeUpdate();
	 	}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	}


