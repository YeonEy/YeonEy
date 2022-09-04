<%@page import="com.dto.GoodsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	GoodsDTO gDTO = (GoodsDTO)request.getAttribute("gDTO");
	System.out.print("goodsRetrive" + gDTO);
	
	String mesg = (String)session.getAttribute("mesg");
	if(mesg != null){
%>    
	<script type="text/javascript">
		alert("<%= mesg %>");
	</script>
<%
	}
	session.removeAttribute("mesg");
%>
	<h1>상품 상세 페이지입니다 :> </h1>
	<jsp:include page="common/top.jsp" flush="true"></jsp:include> <br>
	<jsp:include page="common/menu.jsp" flush="true"></jsp:include>
	<hr>
    <jsp:include page="goods/goodsRetrieve.jsp" flush="true"></jsp:include>