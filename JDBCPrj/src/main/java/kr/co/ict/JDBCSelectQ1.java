package kr.co.ict;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class JDBCSelectQ1 {
	public static void main(String[] args) {
		
		
		try {
			// MYSQL을 연동할것임을 알리기 위해 forName 내부에 MYSQL용 연동구문을 적습니다.
			// SQL 연동은 try~catch블럭 내부에 넣도록 강제됨.
				Class.forName("com.mysql.cj.jdbc.Driver");
				// 커넥션 객체는 연결 여부를 확인합니다.
				// 입력요소는 접속주소,mysql계정명,mysql비밀번호 순으로 입력합니다.
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprac1", // 접속 url
															"root", //  mysql 아이디 
															"mysql");// mysql 비밀번호
		 
			// 쿼리문을 연결된 mysql에 날려주기위해 , 쿼리문을 준비합니다.
			// 쿼리문은 Statement라는 변수에 저장해 날려줍니다.
			Statement stmt = con.createStatement();
			
			// .excuteQuery()내부에 실행할 쿼리문을 매개변수로 작성합니다.
			// SELECT 구문을 실행할 때 excuteQuery()를 실행합니다.
			// SELECT 문을 실행한 결과 자료는 ResultSet 이라는 자료로 받을 수 있습니다.
			
			// stmt.excuteUpdate()는 SELECT이외의 구문, INSERT와 DELETE와 UPDATE를 실행할 때 씁니다.
			
			// Scanner를 이용해 uid를 입력받은 다음 
			// 방금한 SELECT 구문을 응용해서 
			// WHERE uid = 입력받은 아이디
			// 형식으로 내가 조회한 아이디의 정보만 
			// 콘솔에 찍히도록 로직을 작성해주세요.
			
			// WHERE uid = '아이디명' 이므로
			// 아이디명 앞뒤로 작은따음표가 들어갈 수 있도록 
			// 전달 쿼리문을 신경써서 작성해주세요.
			// 힌트 : uid='" + 변수명 + "'"
			Scanner scan =  new Scanner(System.in);
			String uid = scan.nextLine();
			ResultSet rs = stmt.executeQuery("SELECT * FROM userinfo WHERE uid = '"+uid+"'");
			while(rs.next()) {
			
				System.out.println(rs.getString("uid")+"의 정보입니다.");
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


