package com.controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/MyPageServlet")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyPageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO login = (MemberDTO) session.getAttribute("login"); //로그인했던 정보의 dto를 받아 아이디 출력
		System.out.println(login);
		if (login == null) {
			response.sendRedirect("LoginUIServlet");
		} else {
			String userid = login.getUserid();
			MemberService service = new MemberService();
			MemberDTO dto = service.mypage(userid);
			System.out.println(dto);
			
			session.setAttribute("login", dto); //기존에 저장된 세션에 덮어씀
			response.sendRedirect("Mypage.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
