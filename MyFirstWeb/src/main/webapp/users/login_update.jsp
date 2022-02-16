<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 1. 세션에서 아이디를 얻어와 변수에 저장합니다. 세션결과값이 널이면 login_form.jsp로 이동
	
// 2. DB연결 

// 3. 로그인 된 아이디 전체 정보(SELECT * FROM...)을 얻어옵니다.

// 4. name, email을 변수에 저장합니다.

// 5. 하단 form의 value에 해당하는 변수에 든 값이 들어가도록 설정합니다.


 String sId = (String)session.getAttribute("session_id");
// 상위지역에서 미리 tName, tEmail을 표현을 해놓기.
 String tName = "";
String tEmail ="";

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
		String sql= "SELECT * FROM userinfo WHERE uid=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, sId);
		ResultSet rs = pstmt.executeQuery();
		 if(rs.next()){ 
		 tName = rs.getString("uname");
		 tEmail = rs.getString("uemail");
		 }
		 
		
		con.close();
		pstmt.close();
	}
catch(Exception e) {
	e.printStackTrace();
	
} 
	finally{
		
	}

	
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  update의 경우는 update_check.jsp로 자료를 보내야 하는데
보통 정보 수정을 하는 경우는, 미리 회원정보가 form에 기입되어 있는 경우가 많습니다.
먼저 폼 양식은 아이디 없이 비밀번호는 비어있고, name, email은 DB에 있던 정보가 
채워진 상태로 창이 열리게 만들겠습니다. 폼만 완성시켜주세요. -->
<h1><%= sId %>(<%=tName %>)의 정보를 수정합니다. </h1>
<form action="update_check.jsp" method="post">
<input type="password" name="pw" placeholder="비밀번호" required/><br/>
<input type="text" name="name" value="<%= tName %>"  required/><br/>
<input type="email" name="email" value="<%= tEmail %>"  required/><br/>
<input type="submit" value="제출"/><br/>
<input type="reset" value="초기화"/><br/>
</form>

</body>
</html>