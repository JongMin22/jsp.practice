<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String strcm = request.getParameter("height");
	String strkg = request.getParameter("weight");
	
	double cm = Double.parseDouble(strcm);
	double kg = Double.parseDouble(strkg);
	double bmi = kg / (cm/100 * cm/100);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>BMI 계산 웹어플리케이션</h1>
<hr>
<p>
- 신장 : <%= strcm %>cm <br/>
- 체중 : <%= strkg %>kg <br/>
<% if(bmi > 23){
		%> <b>체중조절을 고려해보세요.</b>
	<% }else if(bmi < 18.5){ %>
		<b>당신은 저체중입니다.</b>
	<% }else{ %>
	<b>당신은 정상 체중입니다.</b>		
	<%} 
 	%> 
</p>
	

</body>
</html>