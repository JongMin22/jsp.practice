<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 로또 생성 번호입니다.</h1>
<%  
List<Integer> lotto = new ArrayList();
	int a = 0;
	while(lotto.size()!=6){
		a = (int)(Math.random()* 45 +1);
	if(!lotto.contains(a)){lotto.add(a);}
	
	Collections.sort(lotto);
	
	 }
	 for(Integer num : lotto){
		 out.println(num + "&nbsp;");
		 Thread.sleep(700); // CPU를 잠시 멈추는 메서드
		 out.flush(); // 브라우저의 출력 버퍼를 비우는 메서드
	 }
	  
	 
%>

</body>
</html>