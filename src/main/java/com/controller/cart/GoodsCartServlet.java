package com.controller.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.service.CartService;

/**
 * Servlet implementation class GoodsCartServlet
 */
@WebServlet("/GoodsCartServlet")
public class GoodsCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoodsCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO mDTO = (MemberDTO) session.getAttribute("login");
		
		if (mDTO != null) {
			String userid = mDTO.getUserid();
			String gImage = request.getParameter("gImage");
			String gCode = request.getParameter("gCode");
			String gName = request.getParameter("gName");
			int gPrice = Integer.parseInt(request.getParameter("gPrice"));
			String gSize = request.getParameter("gSize");
			String gColor = request.getParameter("gColor");
			int gAmount = Integer.parseInt(request.getParameter("gAmount"));
			
			CartDTO cDTO = new CartDTO(0, userid, gCode, gName, gPrice, gSize, gColor, gAmount, gImage);
			System.out.println("goodsCartServlet " + cDTO);
			
			CartService service = new CartService();
			int num = service.cartAdd(cDTO);
			System.out.println(num);
			if (num == 1) {
				session.setAttribute("mesg", "장바구니 담기 성공");
				response.sendRedirect("GoodsRetrieveServlet?gCode=" + gCode);
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
