package kr.co.ict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCUpdate {
public static void main(String[] args) {
	
	// UPDATE������ ó�����ּ���.
	// UPDATE�� id�� �������� �ʽ��ϴ�.
	// � ���̵��� pw, name, email�� �������� ��ȸ�ϱ� ����
	// ���� id�� �ް�, �� ���� 
	// pw, name, email�� �޾Ƽ�
	// UPDATE�������� �������� id�� �־� Ÿ���� ���ϰ� 
	// ������ �׸� �����ǵ��� ó�����ּ���.
	String dbname = "com.mysql.cj.jdbc.Driver";
	String dburl = "jdbc:mysql://localhost:3306/jdbcprac1"; 
	String dbid = "root";
	String dbpw = "mysql";
 	try {
		Class.forName(dbname);
		Connection con = DriverManager.getConnection(dburl, // ���� url
													dbid, //  mysql ���̵� 
													dbpw);// mysql ��й�ȣ
 
	
		Statement stmt = con.createStatement();
		Scanner scan = new Scanner(System.in);
		System.out.println("������Ʈ�� ���̵� �Է����ּ���");
		String uid = scan.nextLine();
		//  UPDATE users SET pw='aaa' WHERE id ='aaa';
		System.out.println("������ ��й�ȣ�� �Է����ּ���.");
		String upw = scan.nextLine();
		System.out.println("������ �̸��� �Է����ּ���.");
		String uname = scan.nextLine();
		System.out.println("������ �̸��ϸ� �Է����ּ���.");
		String uemail = scan.nextLine();
		System.out.println("������ ����� �۾�");
		System.out.println("UPDATE userinfo SET upw ='"+upw+"', uname='"+uname+"', uemail='"+uemail+"' WHERE uid ='"+uid+"'");
		stmt.executeUpdate("UPDATE userinfo SET upw ='"+upw+"', uname='"+uname+"', uemail='"+uemail+"' WHERE uid ='"+uid+"'");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
	
}

