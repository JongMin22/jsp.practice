<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    String age = request.getParameter("age");
    String name = request.getParameter("name");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%	 if(id.equals("abcd")){%>
	 <b>중복된 아이디로는 가입할 수 없습니다.</b><br/>
	 
	 <a href="req_join_form.jsp"><b>회원가입창으로 돌아가기</b></a>
 <% }else{%> 
 	<b><%= id %>님 회원가입을 축하드립니다.</b>
 	
 <% }
 %>
</body>
</html>