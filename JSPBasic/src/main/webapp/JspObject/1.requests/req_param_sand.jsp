<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 아래에 form을 만들고 내부에 input 4개를 만들어주세요.
input 태그의 속성은 하나는 text 하나는 password
name속성은 하나는 apple 하나는 banana로 해주세요
reset 버튼과 submuit 버튼도 하나씩 만들어주세요 

form의 action이 바로 목적지를 적는 부분
웹개발에서는 받을 페이지 화면의 주소를 적어줍니다. --%>

<form action="req_param_getpost.jsp" method="get">
<input type=text name="apple" placeholder="사과"/><br/>
<input type=password name="banana" placeholder="바나나"/><br/>

취미 : 
<input type="checkbox" name="hobby" value="요리">요리&nbsp; 
<input type="checkbox" name="hobby" value="독서">독서&nbsp; 
<input type="checkbox" name="hobby" value="운동">운동&nbsp; 
<input type="checkbox" name="hobby" value="맛집탐방">맛집탐방&nbsp; 
<input type="checkbox" name="hobby" value="게임">게임&nbsp;</br> 
전공 : 
<!-- (name, value는 각각 정해주세요. radio 4개를 작성해주시면됩니다.) -->
<input type="radio" name="major" value="한국어"/>한국어&nbsp;
<input type="radio" name="major" value="영어"/>영어&nbsp;
<input type="radio" name="major" value="프랑스어"/>프랑스어&nbsp;
<input type="radio" name="major" value="독일어"/>독일어&nbsp; </br>
<input type=submit value="제출"/>
<input type=reset value="취소"/>

</form>

</body>
</html>