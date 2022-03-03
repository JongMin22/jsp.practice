<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String fId = request.getParameter("fid");
	String fPw = request.getParameter("fpw");
	System.out.println(fId);
	System.out.println(fPw);
	// 1. DB 연결을 변수를 이용해 해주세요.
	// 2. 쿼리문(사용자가 입력해준 fId 조회하기)선언 및 PreparedStatement 객체 생성
	// 3. 쿼리문 실행 결과 ResultSet에 받기
	// 4. 사용자 입력 id를 기준으로 들어온 데이터가 있다면, (fId.equals(DB내에 저장된 ID)로 검사 가능)
	// DB에 적재되어있던 비밀번호를 마저 사용자 입력 비밀번호와 비교해 둘 다 일치하면 세션 발급
	// 그렇지 않다면 로그인에 실패했습니다 메세지가 뜨도록 처리.
	// 5. 만약 웰컴페이지도 만들 여력이 된다면 
	// 가입 이후 리다이렉트로 넘겨서 
	// 이름(아이디) 님 로그인을 환영합니다 라는 문장이 뜨는 login_welcom.jsp까지 구현해주세요.
		String dbType = "com.mysql.cj.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/jdbcprac1"; 
		String dbId = "root";
		String dbPw = "mysql";
	 	try {
	 		Class.forName(dbType);
	 		Connection con = DriverManager.getConnection(dbUrl,dbId,dbPw);
	 		String sql= "SELECT * FROM userinfo WHERE uid=?";
	 		PreparedStatement pstmt = con.prepareStatement(sql);
	 		pstmt.setString(1, fId);
	 		ResultSet rs = pstmt.executeQuery();
	 		
	 		if(rs.next()){
	 			String uId =rs.getString("uid");
	 			String uPw =rs.getString("upw");
	 			String uName =rs.getString("uname");
	 			String uEmail =rs.getString("uemail");
	 			
	 		if(fId.equals(rs.getString(2)) && fPw.equals(rs.getString(3))){
	 			out.println("<h1>"+fId+"님 로그인에 성공하셨습니다.</h1>");
	 				session.setAttribute("session_id", uId);
	 				session.setAttribute("session_pw", uPw);
	 				session.setAttribute("session_name", uName);
	 				session.setAttribute("session_email", uEmail);
	 				
	 				response.sendRedirect("login_welcome.jsp");
	 			}else{out.println("<h1>비밀번호가 틀렸습니다. 다시 확인해주세요.<h1/>");}
	 		}
	 		else{out.println("<h1>아이디가 없습니다. 다시 확인해주세요.");}
			con.close();
			pstmt.close();
	 	}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인에 실패했습니다.</h1> <br/>
<a href="login_form.jsp">로그인 바로가기</a><br/>
<a href="join_form.jsp">회원가입 바로가기</a>

</body>
</html>