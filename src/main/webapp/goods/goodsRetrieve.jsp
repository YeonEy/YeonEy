<%@page import="com.dto.GoodsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
    	$(document).ready(function() {
    		//장바구니 클릭시, 옵션 선택 여부 검사
			$("#cart").click(function() {
				if($("#gSize").val() == "사이즈선택"){
					alert("사이즈를 선택하시오");
					event.preventDefault();
				} else if($("#gColor").val() == "색상선택"){
					alert("색상을 선택하시오");
					event.preventDefault();
				}
			});
			//수량 업,다운
			$("#up").click(function() {
				var gAmount = $("#gAmount").val();
				$("#gAmount").val(parseInt(gAmount) + 1);
			});
			$("#down").click(function() {
				var gAmount = $("#gAmount").val();
				if (gAmount != 1) {
					$("#gAmount").val(parseInt(gAmount) - 1);
				}
			});
		})
    </script>
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
<form name="goodRetrieveForm" method="GET" action="GoodsCartServlet">
	<input type="hidden" name="gImage" value="<%= gDTO.getgImage() %>">
	<input type="hidden" name="gCode" value="<%= gDTO.getgCode() %>">
	<input type="hidden" name="gName" value="<%= gDTO.getgName() %>">
	<input type="hidden" name="gPrice" value="<%= gDTO.getgPrice() %>">
	<table width="100%" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30">
		</tr>
		<tr>
			<td>
				<table align="center" width="710" cellspacing="0" cellpadding="0"
					border="0" style='margin-left: 30px'>
					<tr>
						<td class="td_default"><font size="5"><b>--상품 정보 --</b></font>
							&nbsp;</td>
					</tr>
					<tr>
						<td height="5"></td>
					</tr>
					<tr>
						<td height="1" colspan="8" bgcolor="CECECE"></td>
					</tr>
					<tr>
						<td height="10"></td>
					</tr>

					<tr>
						<td rowspan="7">
							<img src="images/items/<%= gDTO.getgImage() %>.gif" border="0" align="center" width="300" />
						</td>
						<td class="td_title">제품코드</td>
						<td class="td_default" colspan="2" style='padding-left: 30px'>
						 	<%= gDTO.getgCode() %>
						</td>
					</tr>
					<tr>
						<td class="td_title">상품명</td>
						<td class="td_default" colspan="2" style='padding-left: 30px'><%= gDTO.getgName() %></td>
					</tr>
					<tr>
						<td class="td_title">가격</td>

						<td class="td_red" colspan="2" style='padding-left: 30px'>
							<%= gDTO.getgPrice() %>
						</td>
					</tr>
					<tr>
						<td class="td_title">배송비</td>
						<td colspan="2">
							<font color="#2e56a9" size="2" style='padding-left: 30px'><b> 무료배송</b> </font> 
							<font size="2">(도서 산간지역 별도 배송비 추가)</font>
						</td>
					</tr>
					<tr>
						<td class="td_title" rowspan="2">상품옵션</td>
						<td colspan="2" style='padding-left: 30px'>
						<select class="select_change" size="1" name="gSize" id="gSize">
								<option selected value="사이즈선택">사이즈선택</option>
								<option value="L">L</option>
								<option value="M">M</option>
								<option value="S">S</option>
						</select></td>
					</tr>
					<tr>
						<td colspan="2" style='padding-left: 30px'>
						<select class="select_change" size="1" name="gColor" id="gColor">
								<option selected value="색상선택">색상선택</option>
								<option value="navy">navy</option>
								<option value="black">black</option>
								<option value="ivory">ivory</option>
								<option value="white">white</option>
								<option value="gray">gray</option>
						</select></td>
					</tr>

					<tr>
						<td class="td_title">주문수량</td>
						<td style="padding-left: 30px">
							<input type="text" name="gAmount" value="1" id="gAmount" style="text-align: right; height: 18px"> 
							<img src="images/up.PNG" id="up"> 
							<img src="images/down.PNG" id="down">
						</td>
					</tr>
				</table>

			</td>
		</tr>
	</table>
	<br> <button >구매</button>
	&nbsp;&nbsp;
	<button id="cart">장바구니</button>
</form>
    