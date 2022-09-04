<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	MemberDTO dto = (MemberDTO)session.getAttribute("login");
	//로그인시 회원인증 후 login데이터 세션에 저장
	if(dto != null){
%>	
   <%= dto.getUsername() %>님, 반갑습니다 <br>
   <a href="LogoutServlet">로그아웃</a> 
   <a href="">장바구니</a> 
   <a href="MyPageServlet">mypage</a> 
   <a href="CartListServlet">장바구니 목록</a>
<%
	} else {
%>
   <a href="LoginUIServlet">로그인</a> 
   <a href="MemberUIServlet">회원가입</a> 
<%
	}
%>