<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
public int count =0;
int randomNum(){
	return (int)(Math.random()*7 + 2);
	
			}

%>
<%
int currentNum=0;
out.println("페이지 방문자수 : " +  ++count +"</br>");
out.println("고정 숫자 : " +  currentNum);
int a = randomNum();
out.println("<h1>"+"랜덤 구구단"+"("+a+"단)" +"</h1>");
for(int i=1; i<10; i++){
		 out.println("<h2>"+a + " * "+ i + " = " + a*i + "</h2>");}
%>
<body>
</html>