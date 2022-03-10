<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${board.board_num}번 글 수정페이지</h1>
<form action="http://localhost:8181/MyFirstWeb/boardUpdate" method="post">
글제목 : <input type="text" value="${board.title }" name="title"/><br/>
글쓴이 : <input type="text" value="${board.writer }" readonly/><br/>
본문 : <textarea rows="15" cols="50" name="content">${board.content}</textarea><br/>
수정날짜 : <input type="text" value="${board.mdate }" readonly/><br/>
<input type="hidden" value="${board.board_num}" name="boardnum"/>
<input type="submit" value="수정하기"/>
<input type="reset" value="초기화"/>
</form>
 
</body>
</html>