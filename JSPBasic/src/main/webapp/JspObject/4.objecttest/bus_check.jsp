<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String strage = request.getParameter("age");
	int age = Integer.parseInt(strage);
	if(age <= 19){
		response.sendRedirect("bus_child.jsp");
	}
	else if(age >= 20 && age <= 59){
		response.sendRedirect("bus_adult.jsp");}
	else{ response.sendRedirect("bus_senior.jsp");
			
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