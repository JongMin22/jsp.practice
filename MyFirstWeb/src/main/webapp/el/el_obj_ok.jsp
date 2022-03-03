<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// String fName = request.getParameter("name");
	// String fNickName = request.getParameter("nickname");
%>


<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 이름 : <%=fName%>
	 별명 : <%=fNickName%> --%>

-------------------------------------EL식 출력<br/>
이름 : ${param.name }<br/>
별명 : ${param.nick }<br/>
</body>
</html>