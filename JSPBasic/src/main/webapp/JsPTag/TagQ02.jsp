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
int a = randomNum();
out.println("<h1>"+"랜덤 구구단"+"("+a+"단)");
for(int i=1; i<10; i++){
		 out.println(a + " * "+ i + " = " + a*i);
		 %>	 

</body>
</html>