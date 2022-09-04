package com.controller.cart;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.CartService;

/**
 * Servlet implementation class CartDelAllServlet2
 */
@WebServlet("/CartDelAllServlet2")
public class CartDelAllServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CartDelAllServlet2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO mDTO = (MemberDTO) session.getAttribute("login");
		if (mDTO != null) {
			String [] Cnum = request.getParameterValues("check");
			List<String> CartNum = Arrays.asList(Cnum);
			System.out.println(CartNum);
			
			CartService service = new CartService();
			int num = service.CartDeleteAll(CartNum);
			
			if (num != 0) {
				session.setAttribute("mesg", "장바구니 삭제 성공");
				response.sendRedirect("CartListServlet");
			} else {
				session.setAttribute("mesg", "장바구니 삭제 실패");
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
