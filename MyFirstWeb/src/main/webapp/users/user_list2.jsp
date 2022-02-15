<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 아까 발생했던 rs.close() 실행 문제로 인해 
	// DB에있는 자료를 꺼냈을때 , 곧바로 java데이터로 받아오는 작업을 수행한 다음
	// rs.close()를 하면 문제가 없습니다.
	// 따라서 SELECT 구문의 결과(SQL)를 자바 형식으로 담을 클래스가 필요하고
	// 이를 VO(Value Object)라고 부릅니다.
	// VO는 클래스 이기 떄문에 SRC/MAIN/jAVA에 클래스를 선언 및 정의합니다.
	
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