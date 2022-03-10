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

<h1>${board.board_num}번 글 상세페이지</h1>
글제목 : <input type="text" value="${board.title }" readonly/><br/>
글쓴이 : <input type="text" value="${board.writer }" readonly/>
조회수 : ${board.hit }<br/>
쓴날짜 : <input type="text" value="${board.bdate }" readonly/><br/>
마지막 수정날짜 : <input type="text" value="${board.mdate }" readonly/><br/>
본문 : <textarea rows="15" cols="50">${board.content}</textarea><br/>
<a href="http://localhost:8181/MyFirstWeb/boardList">목록으로 돌아가기</a>
<<<<<<< HEAD
<form action="http://localhost:8181/MyFirstWeb/boardDelete" method="post">
<!-- 내부를 조금 고쳐서 글 번호를 넘기도록 만들어 저한테 보내주세요. -->
<input type="hidden" value="${board.board_num}" name="boardnum"/>
<input type="submit" value="삭제하기"/>
</form>
<form action="http://localhost:8181/MyFirstWeb/boardUpdateForm" method="post">
<input type="hidden" value="${board.board_num}" name="boardnum"/>
<input type="submit" value="수정하기"/>
</form>
=======
>>>>>>> c0f3902616b9fe9c8747a7ccbefe3ac990838fb5
 
</body>
</html>