<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Web프로그래밍</h1>
	
	
	<%! 
	
	// Declartion 내부에 
	// 1~10 범위의 난수를 리턴하는 메서드
	// int randomNumber()를 선언해주세요.
	int randomNumber(){
		int result = (int)(Math.random()*9 + 1);
		return result;
	}
		String randomColor(){
		String color[] = {"빨강", "노랑", "파랑"};
		int a = (int)(Math.random()*2);
		 return color[a];
	    
		
	}
		
	// declaration에 선언한 변수는 서버를 끄기 전까지는 누적됩니다.
	public int total =0 ;
	
			
	
	%>	
	
	<h3>오늘의 행운의 숫자와 행운의 색깔</h3>
	<p>행운의 숫자는 1~10 범위입니다.</p>
	<p>행운의 숫자 : <%= randomNumber() %> </p>
	<p>색깔은 1/3확률로 바뀝니다.(빨강,노랑,파랑)</p>
	<p>행운의 색깔 : <%= randomColor() %></p>
	<h3>오늘의 방문자수</h3>
	<%
	out.println(++total);
	int currentNum =0;
	out.println("<br/>");
	out. println(++currentNum);
	%>
</body>
</html>