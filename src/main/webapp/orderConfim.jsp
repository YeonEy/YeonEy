<%@page import="com.dto.MemberDTO"%>
<%@page import="com.dto.CartDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>주문 확인 화면입니다.</h1>
	<jsp:include page="common/top.jsp" flush="true"></jsp:include> <br>
	<jsp:include page="order/orderConfirm.jsp" flush="true"></jsp:include>
	<hr>
	<jsp:include page="member/loginForm.jsp" flush="true"></jsp:include></body>
</html>