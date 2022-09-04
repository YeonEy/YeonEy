<%@page import="com.dto.CartDTO"%>
<%@page import="com.dto.GoodsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
    	$(document).ready(function () {
			$(".dleBtn").click(function() {
				console.log($(this).attr("data-xxx"));
				location.href = "CartDelServlet?num=" + $(this).attr("data-xxx");
			});//
			$(".UpdateBtn").click(function () {
				var num = $(this).attr("data-num");
				var amount = $("#cartAmount"+num).val();
				var price = $("#price").text();
				console.log(num + "\t" + count + "\t" + price);
				
				$.ajax({
					type:"get",
					url:"CartUpdateServlet",
					data:{
						num : num,
						amount : amount
					},
					dataType:"text",
					success: function (data, stauts, xhr) {
						var sum = amount*price;
						console.log(sum);
						$("#sum"+num).text(sum);
					},
					error: function (xhr, status, error) {
						console.log("에러");
					}
				})//end ajax
			});//
			$("#allCheck").click(function () {
				var allCheck = this;
				var checks = $(".check");
				$.each(checks, function (i, e) {
					e.checked = allCheck.checked;
				});
			});//
			$("#delAllCart").click(function () {
				var checks = $(".check:checked");
				var num = [];
				$.each(checks, function (i, e) {
					num[i] = e.value;
				});
				console.log(num);
				location.href="CartDelAllServlet?data="+num;
				//배열로 넘어감 CartDelAllServlet?data=14,16,15,13
			});//
			$("#delAllCart2").click(function () {
				$("#myForm").attr("action", "CartDelAllServlet2");
				$("#myForm").submit();
			});//
			$(".orderBth").click(function () {
				var data = $(this).attr("data-xxx");
				console.log(data);
				location.href ="CartOrderConfirmServlet?num="+data;
			});//
		});//end ready
    </script>
    <%
    	String mesg = (String)session.getAttribute("mesg");
    	if(mesg != null){
    %>
    	<script>
    		alert("<%=mesg%>");
    	</script>
    <%
    	}
    	session.removeAttribute("mesg");
    %>
<table width="90%" cellspacing="0" cellpadding="0" border="0">
	<tr>
		<td height="30">
	</tr>
	<tr>
		<td colspan="5" class="td_default">&nbsp;&nbsp;&nbsp; 
			<font size="5"><b>- 장바구니-</b></font> &nbsp;
		</td>
	</tr>
	<tr>
		<td height="15">
	</tr>
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>
	<tr>
		<td height="7">
	</tr>
	<tr>
		<td class="td_default" align="center">
		<input type="checkbox" name="allCheck" id="allCheck"> <strong>전체선택</strong></td>
		<td class="td_default" align="center"><strong>주문번호</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>상품정보</strong></td>
		<td class="td_default" align="center"><strong>판매가</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>수량</strong></td>
		<td class="td_default" align="center"><strong>합계</strong></td>
		<td></td>
	</tr>
	<tr>
		<td height="7">
	</tr>
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>
	<form name="myForm" id="myForm">	    
<%
	List<CartDTO> list = (List<CartDTO>)session.getAttribute("CartList");
	for(CartDTO dto : list){
%>	    
		<!-- hidden부분 설정부분 	
		<input type="text" name="num81" value="81" id="num81">
		<input type="text" name="gImage81" value="bottom1" id="gImage81">
		<input type="text" name="gName81" value="제나 레이스 스커트" id="gName81">
		<input type="text" name="gSize81" value="L" id="gSize81">
		<input type="text" name="gColor81" value="navy" id="gColor81"> 
		<input type="text" name="gPrice81" value="9800" id="gPrice81"> -->

		<tr>
			<td class="td_default" width="80">
				<!-- checkbox는 체크된 값만 서블릿으로 넘어간다. 따라서 value에 삭제할 num값을 설정한다. -->
				<input type="checkbox" name="check" id="check81" class="check" value="<%=dto.getNum()%>">
			</td>
			<td class="td_default" width="80">
				<%= dto.getNum() %>
			</td>
			<td class="td_default" width="80">
				<img src="images/items/<%= dto.getgImage() %>.gif" border="0" align="center" width="80" />
			</td>
			<td class="td_default" width="300" style='padding-left: 30px'>
				<%= dto.getgName() %>
				<br> <font size="2" color="#665b5f">[옵션 : 사이즈(<%= dto.getgSize() %>), 색상(<%= dto.getgColor() %>)]</font>
			</td>
			<td class="td_default" align="center" width="110" id="price">
				<%= dto.getgPrice() %>
			</td>
			<td class="td_default" align="center" width="90">
				<input class="input_default" type="text" name="cartAmount" id="cartAmount<%=dto.getNum()%>" 
				style="text-align: right" maxlength="3" size="2" value="<%= dto.getgAmount() %>"></input>
			</td>
			<td>
				<input type="button" value="수정" class="UpdateBtn" data-num="<%=dto.getNum()%>"/>
			</td>
			<td class="td_default" align="center" width="80" style='padding-left: 5px'>
				<span id="sum<%=dto.getNum()%>"> <%= dto.getgAmount() * dto.getgPrice() %> </span>
			</td>
			<td>
				<input type="button" value="주문" class="orderBth" data-xxx="<%= dto.getNum() %>"></td>
			<td class="td_default" align="center" width="30" style='padding-left: 10px'>
				<input type="button" value="삭제" class="dleBtn" data-xxx="<%=dto.getNum()%>">
			</td> <!-- data-xxx 사용자 정의 속성 -->
			<td height="10"></td>
		</tr>
<%
	}
%>
	</form>
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>
	<tr>
		<td height="30">
	</tr>

	<tr>
		<td align="center" colspan="5">
			<a class="a_black" href="javascript:orderAllConfirm(myForm)"> 전체 주문하기 </a>&nbsp;&nbsp;&nbsp;&nbsp; 
			<a class="a_black" href="#" id="delAllCart"> 전체 삭제하기1 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="a_black" href="#" id="delAllCart2"> 전체 삭제하기2 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="a_black" href="GoodsListServlet"> 계속 쇼핑하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td height="20">
	</tr>

</table>
    