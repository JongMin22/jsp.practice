package kr.co.ict;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class JDBCSelectQ1 {
	public static void main(String[] args) {
		
		
		try {
			// MYSQL�� �����Ұ����� �˸��� ���� forName ���ο� MYSQL�� ���������� �����ϴ�.
			// SQL ������ try~catch�� ���ο� �ֵ��� ������.
				Class.forName("com.mysql.cj.jdbc.Driver");
				// Ŀ�ؼ� ��ü�� ���� ���θ� Ȯ���մϴ�.
				// �Է¿�Ҵ� �����ּ�,mysql������,mysql��й�ȣ ������ �Է��մϴ�.
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprac1", // ���� url
															"root", //  mysql ���̵� 
															"mysql");// mysql ��й�ȣ
		 
			// �������� ����� mysql�� �����ֱ����� , �������� �غ��մϴ�.
			// �������� Statement��� ������ ������ �����ݴϴ�.
			Statement stmt = con.createStatement();
			
			// .excuteQuery()���ο� ������ �������� �Ű������� �ۼ��մϴ�.
			// SELECT ������ ������ �� excuteQuery()�� �����մϴ�.
			// SELECT ���� ������ ��� �ڷ�� ResultSet �̶�� �ڷ�� ���� �� �ֽ��ϴ�.
			
			// stmt.excuteUpdate()�� SELECT�̿��� ����, INSERT�� DELETE�� UPDATE�� ������ �� ���ϴ�.
			
			// Scanner�� �̿��� uid�� �Է¹��� ���� 
			// ����� SELECT ������ �����ؼ� 
			// WHERE uid = �Է¹��� ���̵�
			// �������� ���� ��ȸ�� ���̵��� ������ 
			// �ֿܼ� �������� ������ �ۼ����ּ���.
			
			// WHERE uid = '���̵��' �̹Ƿ�
			// ���̵�� �յڷ� ��������ǥ�� �� �� �ֵ��� 
			// ���� �������� �Ű�Ἥ �ۼ����ּ���.
			// ��Ʈ : uid='" + ������ + "'"
			Scanner scan =  new Scanner(System.in);
			String uid = scan.nextLine();
			ResultSet rs = stmt.executeQuery("SELECT * FROM userinfo WHERE uid = '"+uid+"'");
			while(rs.next()) {
			
				System.out.println(rs.getString("uid")+"�� �����Դϴ�.");
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


