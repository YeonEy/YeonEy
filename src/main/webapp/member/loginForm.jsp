<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script>
 	$(document).ready(function() {
 		$("#myForm").submit(function() {
			var userid = $("#userid").val();
			var passwd = $("#passwd").val();
			if (userid.length == 0) {
				event.preventDefault();
				$("#userid").focus();
				alert("아이디를 입력하시오");
			} else if (passwd.length == 0){
				event.preventDefault();
				$("#passwd").focus();
				alert("비밀번호를 입력하시오");
			}
		});
	})//end ready
 </script>   
<%
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
	<form action="LoginServlet" method="post" id="myForm">
		아이디: <input type="text" name="userid" id="userid"> <br>
		비밀번호: <input type="text" name="passwd" id="passwd"> <br>
		<input type="submit" value="로그인">
		<input type="reset" value="취소"> 
	</form>
