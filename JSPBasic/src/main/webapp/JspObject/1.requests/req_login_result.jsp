<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("password");
	
	String myid = "q2ewrq2ewr";
	String mypw = "*q2ewrq2ewr";			
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(id.equals(myid) && pw.equals(mypw)){%>
	<b><%=id %>님 접속을 환영합니다.</b><% }
else{%><b>로그인에실해했습니다.</b>
<a href="req_Login_form.jsp"><b>로그인창으로 돌아가기</b></a>)
<% }
%>
</body>
</html>