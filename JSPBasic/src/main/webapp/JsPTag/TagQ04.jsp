<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- JSP주석은 이렇게 작성합니다. 
JSP 주석은 소스보기에 나타나지 않습니다.--%>
<!--  html주석은 소스보기에 나타납니다. -->
<%-- 선언부를 이용해서 함수 및 변수를 만들어 보세요.
변수는 celcius 라는 이름의 double형 변수로 만들어주세요.
함수는 CtoF라는 이름의 double형 자료를 하나 입력받고 
double형 자료를 리턴해주게 만들어주세요.
celcius라는 함수는 오늘의 섭씨온도로 초기화시켜주세요.
스크립트릿을 이용해서 celcius를 피라미터로 넘겨서 CtoF 함수를 호출해주세요.
함수를 호출한 결과를 out.println()으로 화면에 표출시켜주면됩니다.
화씨 -- > 섭씨 공식
(화씨온도 - 32) / 1.8 = 섭씨온도 --%>
<%!  double celcius; 
    double CtoF(double a){
	return a; 
	}
	double celcius(){
		return celcius=0;
		
	}
	double FtoC(double a){
		return a*1.8 + 32; 
		}
%>
<%   
	out.println("오늘의 섭씨온도: "+CtoF(celcius()) + "</br>");
	out.println("오늘의 화씨온도: "+FtoC(celcius()));
%>
</body>
</html>