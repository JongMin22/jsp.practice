package kr.co.ict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCInsert {
	public static void main(String[] args) {
		// Scanner로 id,pw,name,eamil을 입력받아
		// Insert into 구문을 이용해 DB에 데이터를 삭제하도록 만들어보겠습니다.
		
		
		// SELECT Q1처럼 작성해주시되(입력받기, DB연결, 쿼리문 실행 등..)
		// SELECT구문을 제외한 나머지 INSERT, DELELTE, UPDATE 구문은
		// 결과 데이터가 없기 떄문에 실행했을때 에러가 나지 않는다면 
		// 우선 실행된것으로 볼 수 있고, 실행이 된 다음 워크벤치에서
		// 데이터가 들어갔는지 확인해주면 됩니다.
		
		// 쿼리문 실행시 SELECT구문은 excuteQuery(구문); 을 호출했지만
		// SELECT이외 구문은 excuteUpdate(구문);을 호출합니다.
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprac1", // 접속 url
															"root", //  mysql 아이디 
															"mysql");// mysql 비밀번호
		 
			// 쿼리문을 연결된 mysql에 날려주기위해 , 쿼리문을 준비합니다.
			// 쿼리문은 Statement라는 변수에 저장해 날려줍니다.
			Statement stmt = con.createStatement();
			
			// .excuteQuery()내부에 실행할 쿼리문을 매개변수로 작성합니다.
			// SELECT 구문을 실행할 때 excuteQuery()를 실행합니다.
			// SELECT 문을 실행한 결과 자료는 ResultSet 이라는 자료로 받을 수 있습니다.
			
			// stmt.executeUpdate()는 SELECT이외의 구문, INSERT와 DELETE와 UPDATE를 실행할 때 씁니다.
			
			System.out.println("id를 입력해주세요");
			Scanner scan =  new Scanner(System.in);
			String uid = scan.nextLine();
			System.out.println("pw를 입력해주세요");
			String upw = scan.nextLine();
			System.out.println("name를 입력해주세요");
			String uname = scan.nextLine();
			System.out.println("email를 입력해주세요");
			String uemail = scan.nextLine();
			
			
			
			
			
			// 디버깅을 위해 쿼리문 실행전 콘솔에서 조회
			System.out.println("실행예정 쿼리문");
			System.out.println("INSERT INTO userinfo VALUES ('" + uname +"' , '"+ uid +"' , '" + upw + "' , '" + uemail + "')");
			System.out.println("==================================================");
			
			stmt.executeUpdate("INSERT INTO userinfo VALUES ('" + uname +"' , '"+ uid +"' , '" + upw + "' , '" + uemail + "')");
			
		}	
			catch(Exception e) {
				e.printStackTrace();
			}
	}
}


