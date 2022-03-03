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
<%--
 
int total=0;
for(int i=1; i<101; i++){
total += i;
}
out.println("<h1>1부터 100까지 총합은 : " + total + "</h1>");
--%>
<!-- begin은 시작값, end는 끝값(포함값), step은 증가숫자 var는 태그내에서 쓸 변수명 -->
<c:forEach begin="1" end="100" step="1" var="number">
<c:set var="total" value="${total + number}"/>

</c:forEach>
<h1>1~100까지의 누적합 : ${total}</h1>
<hr/>
<!-- foreach문을 이용해서 구구단 4단을 출력해보세요. -->
<c:forEach begin="2" end="9" step="1" var="dan">
<h1>${dan}단</h1>
<c:forEach begin="1" end="9" step="1" var="number">
<h2>${dan} * ${number} = ${dan*number}</h2>
</c:forEach>
</c:forEach>


<hr/>	
<h1>숫자가 아닌 요소를 반복하는 JSTL</h1>
<%-- arr변수 내에 과일5개 이름을 배열로 저장하는 구문 --%>
<c:set var="arr" value='<%= new String[] {"사과","딸기","망고","바나나","포도"}%>'/>
<%-- forEach는 향상된  for문처럼 쓸 수도 있습니다. --%>
<c:forEach var="i" items="${arr }">
	${i} &nbsp;
</c:forEach>
<%-- 
String[] arr = {"사과","딸기","망고","바나나","포도"};
	for(int i : arr){
	out.println(i + "&nbsp;")
	}
	--%>
	<!--  int배열에 10,20,30,40,50을 넣어주시고 
	forEach문을 이용해 화면에 출력해주세요. 변수명은 마음대로 -->
	<c:set var="numarr" value='<%=new int[] {10,20,30,40,50}%>'/>
	<c:forEach var="i" items="${numarr}">
	${i} &nbsp;
	</c:forEach>
	
</body>
</html>