package com.controller.goods;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.GoodsDTO;
import com.service.GoodsService;

/**
 * Servlet implementation class GoodsRetrieveServlet
 */
@WebServlet("/GoodsRetrieveServlet")
public class GoodsRetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoodsRetrieveServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gCode = request.getParameter("gCode");
		System.out.println(gCode);
		
		GoodsService service = new GoodsService();
		GoodsDTO gDTO = service.goodsOneSelect(gCode);
		System.out.println(gDTO);
		
		request.setAttribute("gDTO", gDTO);
		
		RequestDispatcher dis = request.getRequestDispatcher("goodsRetrieve.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
