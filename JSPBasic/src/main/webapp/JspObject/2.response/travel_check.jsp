<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String travel = request.getParameter("travel");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	if(travel.equals("saltdesert")){
		response.sendRedirect("travel_saltdesert.jsp");
	}
	else if(travel.equals("karzino")){
		response.sendRedirect("travel_karzino.jsp");	
	}
	else if(travel.equals("england")){
		response.sendRedirect("travel_england.jsp");
	}
	else if(travel.equals("ghangahnri")){
		response.sendRedirect("travel_ghangahnri.jsp");
	}
	%>

</body>
</html>