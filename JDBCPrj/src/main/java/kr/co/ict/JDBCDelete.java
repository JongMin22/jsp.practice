package kr.co.ict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDelete {
	public static void main(String[] args) {
		
		// ����ڰ� Scanner�� ���̵� �Է��ϸ�
		// �ش� ���̵� ������ DB���� �����ǵ��� ������ �ۼ��غ�����.
		// ���� executeUpdate("���๮"); ���� �����մϴ�.
		// Insert���� �ù� ������ȵ� ���� ���� �ܼ��� �̿��ؼ�
		// �������� ������ �ۼ��Ǿ����� Ȯ���� �� �ֵ��� �����ִ� �ڵ嵵
		// ���� �ۼ����ּ���.
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprac1", // ���� url
														"root", //  mysql ���̵� 
														"mysql");// mysql ��й�ȣ
	 
		
			Statement stmt = con.createStatement();
			Scanner scan = new Scanner(System.in);
			System.out.println("������ ���̵� �Է����ּ���");
			String uid = scan.nextLine();
			
			System.out.println("������ ����� �۾�");
			System.out.println("DELETE FROM userinfo WHERE uid ='"+uid+"'");
			stmt.executeUpdate("DELETE FROM userinfo WHERE uid ='"+uid+"'");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
