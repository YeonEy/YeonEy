package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;
import com.dto.OrderDTO;

public class CartDAO {

	public int cartAdd(SqlSession session, CartDTO cDTO) {
		int num = session.insert("cartInsert", cDTO);
		return num;
	}

	public List<CartDTO> CartList(SqlSession session, String userid) {
		List<CartDTO> list = session.selectList("CartMapper.CartList", userid);
		return list;
	}

	public int cartDel(SqlSession session, String cartNum) {
		int num = session.delete("cartDel", cartNum);
		return num;
	}

	public int cartListUpdate(SqlSession session, Map<String, String> map) {
		int num = session.update("cartListUpdate", map);
		return num;
	}

	public int CartDeleteAll(SqlSession session, List<String> cartID) {
		int num = session.delete("CartDeleteAll", cartID);
		return num;
	}

	public CartDTO cartbyNum(SqlSession session, String num) {
		CartDTO cDTO = session.selectOne("cartbyNum", num);
		return cDTO;
	}

	public int orderDone(SqlSession session, OrderDTO oDTO) {
		int num = session.insert("orderDone", oDTO);
		return num;
	}

	
	
}
