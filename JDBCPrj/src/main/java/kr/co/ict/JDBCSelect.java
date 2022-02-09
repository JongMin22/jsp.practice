package kr.co.ict;
// SQL ���õ� ��Ҵ� java.sql.*�� ����Ʈ�ϸ� ��κ��� �� �ε�˴ϴ�.
import java.sql.*;
public class JDBCSelect {
	public static void main(String[] args) {
		// JDBC ���� ���� Ȯ��
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
		ResultSet rs = stmt.executeQuery("SELECT * FROM userinfo");
		// stmt.excuteUpdate()�� SELECT�̿��� ����, INSERT�� DELETE�� UPDATE�� ������ �� ���ϴ�.
		System.out.println(rs);
		
		// ResultSet�� �⺻������ row������ŭ ���ο� �����͸� �����մϴ�.
		// ResultSet�� Ư�� ��ȣ�� ��� ��ȸ�ϴ� ��캸�ٴ� ���������� 
		// ��ȸ�ؼ� ���� ��찡 �����ϴ�.
		// �� ó�� ResultSet�� -1���̶�� �ӽù�ȣ�� Ÿ������ ����ϴ�.
		// �� ��ȣ�� �ű�� ���� .next()�� ȣ���ϸ� ���� ��ȣ�� �Ѿ�ϴ�.
		// rs.next(); // ���� ��ȣ�� ��ȸ�Ǹ� true, ������ false
		// get�ڷ���(�ε�����ȣ, 1����) or get�ڷ���(�ڷ��(�÷���))�� ����
		// �ش��÷��� �ڷḦ ��ȯ
		// System.out.println(rs.getString(1));
		// System.out.println(rs.getString(2));
		// System.out.println(rs.getString(3));
		// System.out.println(rs.getString(4));
		
		
		// while���� �̿��ؼ� select������ ��ü �����
		// �ֿܼ� ����ּ���.
		int i=1;
		while(rs.next()) {
			System.out.println(rs.getString("uname"));
			System.out.println(rs.getString(i+1));
			System.out.println(rs.getString(i+2));
			System.out.println(rs.getString("uemail"));
			System.out.println("---------------------------");

		}
		   
		
		}	
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
