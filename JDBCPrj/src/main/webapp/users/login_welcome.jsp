<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%  
	String id = (String)session.getAttribute("session_id");
	String name = (String)session.getAttribute("session_name");
	out.println(name+"("+id+")님 로그인을 환영합니다.");
	
	
	 if(id == null){
		response.sendRedirect("session_login.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>