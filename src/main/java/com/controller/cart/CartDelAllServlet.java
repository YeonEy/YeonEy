package com.controller.cart;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
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
 * Servlet implementation class CartDelAllServlet
 */
@WebServlet("/CartDelAllServlet")
public class CartDelAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CartDelAllServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO mDTO = (MemberDTO) session.getAttribute("login");
		if (mDTO != null) {
			String num = request.getParameter("data"); //문자열로 받아서
			String [] data = num.split(","); //,을 기준으로 자르고
			List<String> CartID = Arrays.asList(data); //list에 넣음
			System.out.println(CartID);
			
			CartService service = new CartService();
			int CartDelNum = service.CartDeleteAll(CartID);
			System.out.println(CartDelNum);
			
			if (CartDelNum != 0) {
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
