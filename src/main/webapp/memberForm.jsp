<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>memberForm.jsp :> </h1>
	<jsp:include page="common/top.jsp" flush="true"></jsp:include> <br>
	<jsp:include page="common/menu.jsp" flush="true"></jsp:include> 
	<hr>
	<jsp:include page="member/memberForm.jsp" flush="true"></jsp:include> <!-- 실제 회원 가입 구현 화면 -->
</body>
</html>