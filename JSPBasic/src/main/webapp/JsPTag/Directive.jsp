<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%
	// 자바에서 import구문을 이용해 사용하던 클래스들은 JSP파일에서도 역시
	// import구문을 써야 합니다.
	// 지시자(Directive)의 경우 <%@ % >사이에 기술하여
	// 문서자체에 사용할 설정이나 옵션을 지정합니다.
	Date date = new Date();// 날짜 얻어오기
	
	List<String> names = new ArrayList();
	
	// 이름 4개를 추가해보세요. 
	names.add("보라돌이");
	names.add("뚜비");
	names.add("나나");
	names.add("뽀");
	
	out.println(names.toString() +"<br/>");
	out.println(names.get(1) + "<br/>");
	
	out.println(date.getDate() + "<br/>");
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