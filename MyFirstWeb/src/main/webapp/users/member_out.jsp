<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sId = (String)session.getAttribute("session_id");
	String sName = (String)session.getAttribute("session_name");
// DB 연결후, 세션에서 받아온 아이디를 이용해
// 회원탈퇴후 body태그 내에는 "아이이 회원의 탈퇴가 완료되었습니다."
// 출력하고 실제로 DB에 DELET구문을 날려서 삭제까지 처리해주세요.

// 로그인 안한 사용자가 접근시 login_form.jsp로 보내주세요.
if(sId == null){
	 response.sendRedirect("login_form.jsp");
}

	String dbType = "com.mysql.cj.jdbc.Driver";
	String dbUrl = "jdbc:mysql://localhost:3306/jdbcprac1"; 
	String dbId = "root";
	String dbPw = "mysql";
 	try {
 		Class.forName(dbType);
 		Connection con = DriverManager.getConnection(dbUrl,dbId,dbPw);
 		String sql= "DELETE FROM userinfo WHERE uid=?";
 		PreparedStatement pstmt = con.prepareStatement(sql);
 		pstmt.setString(1, sId);
 		pstmt.executeUpdate();
 		
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
<h1><%=sName %>(<%=sId %>)회원의 탈퇴가 완료되었습니다.</h1>
</body>
</html>