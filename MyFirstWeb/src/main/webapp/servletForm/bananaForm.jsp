<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  서블릿으로 보내기 위해서는 action에 서블릿 접속 주소를 복붙합니다. -->
<form action="http://localhost:8181/MyFirstWeb/banana" method="post">
<!-- /spring에서 받을 수 있도록 처리해주세요 input text3개를 만들어서
submit 버튼을 눌렀을때 /banana의 콘솔에서 해당 자료들을 받아서 콘솔에 찍도록
form을 코딩한 다음 보내주세요. -->
<input type="text" name="jsp" placeholder="jsp"/><br/>
<input type="text" name="boot" placeholder="boot"/><br/>
<input type="text" name="jpa" placeholder="jpa"/><br/>
<input type="submit" value="제출"/>
</form>

</body>
</html>