<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  jspl_form2.jsp를 만들어서 목적지를 여기로 해주시고
실제로 보낸 데이터가 출력되도록 만들어주세요 -->
<c:choose>
<c:when test="${param.lang eq '자바'}">
	당신은 자바로 웹 개발을 합니다.
</c:when>
<c:when test="${param.lang eq '파이썬'}">
	<p>당신은 자바로 파이썬으로 개발을 합니다.</p>
</c:when>
<c:otherwise>
		<p>당신은 php로 웹 개발을 합니다.</p>
</c:otherwise>
</c:choose>
</body>
</html>