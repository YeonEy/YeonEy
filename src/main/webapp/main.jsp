<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.dto.GoodsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
	</style>
</head>
<body>
	<h1>main홈 페이지 :> </h1>
	<jsp:include page="common/top.jsp" flush="true"></jsp:include> <br>
	<jsp:include page="common/menu.jsp" flush="true"></jsp:include>
	<%
		String mesg = (String)session.getAttribute("mesg");
		if(mesg != null){
	%>
	<script type="text/javascript">
		alert("<%= mesg%>"); 
	</script>
	<%
		session.removeAttribute("mesg"); //회원로그인후 한번만 메세지가 뜨고 세션을 지움
		}
	%> 
	<hr> 
 	<jsp:include page="goods/goodsList.jsp" flush="true"></jsp:include>
</body>
</html>