<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가고싶은 여행지들</title>
</head>
<body>
<%-- 
form 태그를 만들고 목적지는 travel_check.jsp, post방식입니다.
라디오버튼을 최소4개 만들어주세요. --%>
<h1>가고싶은 여행지</h1>
<form action="travel_check.jsp" method="post">
<input type="radio" name="travel" value="saltdesert"/>소금사막<br/>
<input type="radio" name="travel" value="karzino"/>카지노<br/>
<input type="radio" name="travel" value="ghangahnri"/>광안리<br/>
<input type="radio" name="travel" value="england"/>영국<br/>
<input type="submit" value="여행지선택"/>
</form>

</body>
</html>