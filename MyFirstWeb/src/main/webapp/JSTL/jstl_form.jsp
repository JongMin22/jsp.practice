<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  jstl_if를 목적지로 하는 폼을 만들어서 
	입력한 요소를 전달하도록 홈 코드를 작성해주세요.
	submit버튼을 눌러 제출합니다. -->
<form action="jstl_if.jsp">
<input type="text" name="name" placeholder="이름"/>
<input type="submit" value="제출"/>
<input type="reset" value="초기화"/>
</form>

</body>
</html>