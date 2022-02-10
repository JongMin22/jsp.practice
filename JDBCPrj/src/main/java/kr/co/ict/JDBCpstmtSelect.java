package kr.co.ict;

import java.sql.*;
import java.util.Scanner;


public class JDBCpstmtSelect {
	public static void main(String[] args) {
		// DB����, ������� ���� �غ�����
		// DB����, ��Ű���ּ�. ������, ����� ������ �����մϴ�.
		String dbname = "com.mysql.cj.jdbc.Driver";
		String dburl = "jdbc:mysql://localhost:3306/jdbcprac1"; 
		String dbid = "root";
		String dbpw = "mysql";
	 	try {
	 		// ��������� ��ȸ�� ���̵� �Է¹ޱ�
	 		Scanner scan = new Scanner(System.in);
	 		System.out.println("��ȸ�ϰ� ���� ���̵� �Է����ּ���.");
	 		String uid = scan.nextLine();
	 		// DB���� ����
			Class.forName(dbname);
			// DB����
			Connection con = DriverManager.getConnection(dburl, // ���� url
														dbid, //  mysql ���̵� 
														dbpw);// mysql ��й�ȣ
			// 3.PreparedStatement������ �չ� SQL�������� �������� �����մϴ�.
			// �߰��� ����� �Է� ������ �޴� �κ��� ���� ? �θ� ġȯ�ؼ� �����մϴ�.
			// ?�� 2�� �̻� �� ���� �ֽ��ϴ�.
			String sql= "SELECT * FROM userinfo WHERE uid=?";
			
			// pstmt ������ ����� �����մϴ�
			PreparedStatement pstmt = con.prepareStatement(sql);
			// ?�� �� �ڷḦ �������ݴϴ�.
			pstmt.setString(1, uid); // 29������ 1�� ? �ڸ��� uid�� �־��ְڴٴ� �ǹ�
			// 4. ������ ����
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
