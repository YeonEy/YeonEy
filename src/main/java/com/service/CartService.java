package com.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.CartDAO;
import com.dto.CartDTO;
import com.dto.OrderDTO;

public class CartService {
	
	CartDAO dao;
	
	public CartService() {
		dao = new CartDAO();
	}

	public int cartAdd(CartDTO cDTO) {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSqlSession();
		try {
			num = dao.cartAdd(session, cDTO);
			session.commit();
		} catch (Exception e) {
			session.close();
		}
		return num;
	}

	public List<CartDTO> CartList(String userid) {
		List<CartDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSqlSession();
		try {
			list = dao.CartList(session, userid);
		} finally {
			session.close();
		}
		return list;
	}

	public int cartDel(String cartNum) {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSqlSession();
		try {
			num = dao.cartDel(session, cartNum);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}

	public int cartListUpdate(Map<String, String> map) {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSqlSession();
		try {
			num = dao.cartListUpdate(session, map);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}

	public int CartDeleteAll(List<String> cartID) {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSqlSession();
		try {
			num = dao.CartDeleteAll(session, cartID);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}

	public CartDTO cartbyNum(String num) {
		CartDTO cDTO = null;
		SqlSession session = MySqlSessionFactory.getSqlSession();
		try {
			cDTO = dao.cartbyNum(session, num);
		} finally {
			session.close();
		}
		return cDTO;
	}

	public int orderDone(OrderDTO oDTO, String num) {
		int n = 0;
		int m = 0;
		SqlSession session =MySqlSessionFactory.getSqlSession();
		try {
			n = dao.orderDone(session, oDTO);
			m = dao.cartDel(session, num);
			session.commit();
		} finally {
			if (n == 0 || m == 0) {
				session.rollback();
			}
			session.close();
		}
		System.out.println("오더테이블 인서트 갯수"+n);
		System.out.println("장바구니테이블 삭제 갯수"+m);
		return n + m;
	}

}
