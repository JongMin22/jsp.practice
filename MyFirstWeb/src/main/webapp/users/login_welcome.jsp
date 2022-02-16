<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%  
	// 세션에 저장된 정보를 확인해 
	// ID님 접속을 환영합니다. 라고 안내해주는 만들어보겠습니다.
	// 추후 여기에는 탈퇴하기, 로그아웃하기, 정보수정하기 버튼이 추가될예정입니다.
    String id = (String)session.getAttribute("session_id");
    String name = (String)session.getAttribute("session_name");
	out.println(name+"("+id +")님 로그인을 환영합니다.<br/>");
	 if(id == null){
		response.sendRedirect("login_form.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="login_update.jsp">정보수정하기</a><br/>
<a href="logout.jsp">로그아웃하기</a><br/> <!--  세션 파기 후 login_form.jsp -->
<a href="member_out.jsp">회원탈퇴하기</a><!--  회원탈퇴를 위해 member_out.jsp를 만들어보겠습니다. -->
<!--  회원목록보기 링크를 만들어주세요. -->
<a href="user_list2.jsp">회원목록보기.</a>
</body>
</html>