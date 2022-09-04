package com.controller.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.CartService;

/**
 * Servlet implementation class CartDelServlet
 */
@WebServlet("/CartDelServlet")
public class CartDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CartDelServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cartNum = request.getParameter("num");
		System.out.println("장바구니 번호 " + cartNum);
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		if (dto != null) {
			CartService service = new CartService();
			int num = service.cartDel(cartNum);
			System.out.println(num);
			if (num == 1) {
				session.setAttribute("mesg", "장바구니 목록 삭제 성공");
				response.sendRedirect("CartListServlet");
			} else {
				session.setAttribute("mesg", "장바구니 목록 삭제 실패");
				response.sendRedirect("CartListServlet");
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
