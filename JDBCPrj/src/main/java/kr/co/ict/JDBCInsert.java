package kr.co.ict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCInsert {
	public static void main(String[] args) {
		// Scanner�� id,pw,name,eamil�� �Է¹޾�
		// Insert into ������ �̿��� DB�� �����͸� �����ϵ��� �����ڽ��ϴ�.
		
		
		// SELECT Q1ó�� �ۼ����ֽõ�(�Է¹ޱ�, DB����, ������ ���� ��..)
		// SELECT������ ������ ������ INSERT, DELELTE, UPDATE ������
		// ��� �����Ͱ� ���� ������ ���������� ������ ���� �ʴ´ٸ� 
		// �켱 ����Ȱ����� �� �� �ְ�, ������ �� ���� ��ũ��ġ����
		// �����Ͱ� ������ Ȯ�����ָ� �˴ϴ�.
		
		// ������ ����� SELECT������ excuteQuery(����); �� ȣ��������
		// SELECT�̿� ������ excuteUpdate(����);�� ȣ���մϴ�.
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprac1", // ���� url
															"root", //  mysql ���̵� 
															"mysql");// mysql ��й�ȣ
		 
			// �������� ����� mysql�� �����ֱ����� , �������� �غ��մϴ�.
			// �������� Statement��� ������ ������ �����ݴϴ�.
			Statement stmt = con.createStatement();
			
			// .excuteQuery()���ο� ������ �������� �Ű������� �ۼ��մϴ�.
			// SELECT ������ ������ �� excuteQuery()�� �����մϴ�.
			// SELECT ���� ������ ��� �ڷ�� ResultSet �̶�� �ڷ�� ���� �� �ֽ��ϴ�.
			
			// stmt.executeUpdate()�� SELECT�̿��� ����, INSERT�� DELETE�� UPDATE�� ������ �� ���ϴ�.
			
			System.out.println("id�� �Է����ּ���");
			Scanner scan =  new Scanner(System.in);
			String uid = scan.nextLine();
			System.out.println("pw�� �Է����ּ���");
			String upw = scan.nextLine();
			System.out.println("name�� �Է����ּ���");
			String uname = scan.nextLine();
			System.out.println("email�� �Է����ּ���");
			String uemail = scan.nextLine();
			
			
			
			
			
			// ������� ���� ������ ������ �ֿܼ��� ��ȸ
			System.out.println("���࿹�� ������");
			System.out.println("INSERT INTO userinfo VALUES ('" + uname +"' , '"+ uid +"' , '" + upw + "' , '" + uemail + "')");
			System.out.println("==================================================");
			
			stmt.executeUpdate("INSERT INTO userinfo VALUES ('" + uname +"' , '"+ uid +"' , '" + upw + "' , '" + uemail + "')");
			
		}	
			catch(Exception e) {
				e.printStackTrace();
			}
	}
}


