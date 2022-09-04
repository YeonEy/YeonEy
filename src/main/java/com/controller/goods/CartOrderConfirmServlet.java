package com.controller.goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.service.CartService;
import com.service.MemberService;

/**
 * Servlet implementation class CartOrderConfirmServlet
 */
@WebServlet("/CartOrderConfirmServlet")
public class CartOrderConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CartOrderConfirmServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String num = request.getParameter("num");
		System.out.println("주문번호 " + num);
		
		HttpSession session = request.getSession();
		MemberDTO mDTO = (MemberDTO) session.getAttribute("login");
		
		if (mDTO != null) {
			CartService service = new CartService();
			CartDTO cDTO = service.cartbyNum(num);
			System.out.println(cDTO);
			
			String userid = mDTO.getUserid();
			MemberService Mservice = new MemberService();
			MemberDTO m = Mservice.mypage(userid);
			System.out.println(m); //사용자 정보
			
			request.setAttribute("cDTO", cDTO); //주문 상품 정보
			request.setAttribute("mDTO", m); // 주문 고객 정보
			
			RequestDispatcher dis = request.getRequestDispatcher("orderConfim.jsp");
			dis.forward(request, response);
			
		} else {
			session.setAttribute("mesg", "로그인이 필요합니다");
			response.sendRedirect("LoginUIServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
