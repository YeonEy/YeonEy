package com.controller.goods;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.dto.OrderDTO;
import com.service.CartService;

/**
 * Servlet implementation class CartOrderDoneServlet
 */
@WebServlet("/CartOrderDoneServlet")
public class CartOrderDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CartOrderDoneServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("utf-8");
		HttpSession session = request.getSession();
		MemberDTO mDTO = (MemberDTO) session.getAttribute("login");
		if (mDTO != null) {
			 String num = request.getParameter("num"); 
			 String userid = mDTO.getUserid();
			 String gCode = request.getParameter("gCode");
			 String gName = request.getParameter("gName");
			 String gPrice = request.getParameter("gPrice");
			 String gSize = request.getParameter("gSize");
			 String gColor = request.getParameter("gColor");
			 String gAmount = request.getParameter("gAmount");
			 String gImage = request.getParameter("gImage");
			 String orderName = request.getParameter("orderName");
			 String post = request.getParameter("post");
			 String addr1 = request.getParameter("addr1");
			 String addr2 = request.getParameter("addr2");
			 String phone = request.getParameter("phone");
			 String payMethod = request.getParameter("payMethod");
			 
			 OrderDTO oDTO = new OrderDTO(Integer.parseInt(num), userid, gCode, gName, Integer.parseInt(gPrice), gSize, gColor, 
					 	Integer.parseInt(gAmount), gImage, orderName, post, addr1, addr2, phone, payMethod, null);
			 System.out.println("주문 정보 " + oDTO);
			 System.out.println("장바구니 번호 " + num);
			 
			 CartService service = new CartService();
			 int n = service.orderDone(oDTO, num);
			 System.out.println(n);
			 
			 if (n != 0) {
				session.setAttribute("userid", userid);
				session.setAttribute("orderDTO", oDTO);
				session.setAttribute("mesg", "장바구니 담기 성공");
				response.sendRedirect("orderDone.jsp");
			} else {
				session.setAttribute("mesg", "장바구니 담기 실패");
				response.sendRedirect("GoodsCartServlet");
			}
		} else {
			session.setAttribute("mesg", "로그인이 필요합니다");
			response.sendRedirect("LoginUIServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
