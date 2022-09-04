package com.service;

import java.util.List;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.GoodsDAO;
import com.dto.GoodsDTO;

public class GoodsService {
	
	GoodsDAO dao;

	public GoodsService() {
		super();
		dao = new GoodsDAO();
	}

	public List<GoodsDTO> goodsList(String top) {
		List<GoodsDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSqlSession();
		try {
			list = dao.goodsList(session, top);
		} finally {
			session.close();
		}
		return list;
	}

	public GoodsDTO goodsOneSelect(String gCode) {
		GoodsDTO gDTO = null;
		SqlSession session = MySqlSessionFactory.getSqlSession();
		try {
			gDTO = dao.goodsOneSelect(session, gCode);
		} finally {
			session.close();
		}
		return gDTO;
	}

}
