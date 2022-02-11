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
	 		System.out.println("������Ʈ�� ���̵� �Է����ּ���.");
	 		String uid = scan.nextLine();
	 		System.out.println("���� ����� ��й�ȣ�� �Է����ּ���.");
	 		String upw = scan.nextLine();
	 		System.out.println("���� ����� �̸����� �Է����ּ���.");
	 		String uemail = scan.nextLine();
	 		System.out.println("���� ����� �̸��� �Է����ּ���.");
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
			
			// .close()�� ���� �ڷ� �ݱ�
			// �Ϲ� �ڹ��ڵ�� ������ �ڵ������ ������ ���α׷��� ������ ���������
			// ������ ���� �ڵ������ ������ ������ ��� ���ư� �ڿ�ȸ���� �� ���ָ� ���� �ý��ۿ� ���ϰ� �ɸ����� ����.
			// �̸� ���� ���� ȣ���� ���� �ڿ��� .close()�� ��������� �� ��� ��.
			
			con.close();
			pstmt.close();
			scan.close();
			
	 	}
		catch(Exception e) {
			e.printStackTrace();
		}
	 	finally {
	 		// ���ᱸ���ȳ�  + .close()�� ���� �ڷ� �ݱ�
	 		System.out.println("�����Ϸ�");
	 	}
		
	}

}
