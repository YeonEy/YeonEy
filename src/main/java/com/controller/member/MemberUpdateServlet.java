package com.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;

import javafx.scene.control.Alert;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/MemberUpdateServlet")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String post = request.getParameter("post");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		
		MemberDTO dto = new MemberDTO();
		dto.setUserid(userid);
		dto.setAddr1(addr1);
		dto.setAddr2(addr2);
		dto.setPost(post);
		dto.setPhone1(phone1);
		dto.setPhone2(phone2);
		dto.setPhone3(phone3);
		dto.setEmail1(email1);
		dto.setEmail2(email2);
		System.out.println("memberUpdate" + dto);
		
		HttpSession session = request.getSession();
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		if (login != null) {
			MemberService service = new MemberService(); 
			int num = service.memberUpdate(dto); 
			System.out.println(num);
			
			if (num == 1) {
				dto = service.mypage(userid);
				session.setAttribute("login", dto);
				session.setAttribute("mesg", "회원 정보 수정 완료"); 
				response.sendRedirect("main");
			}
		} else {
			response.sendRedirect("LoginUIServlet");
		}
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
