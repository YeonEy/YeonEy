package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.GoodsDTO;

public class GoodsDAO {

	public List<GoodsDTO> goodsList(SqlSession session, String top) {
		List<GoodsDTO> list = session.selectList("GoodsMapper.goodsList", top);
		return list;
	}

	public GoodsDTO goodsOneSelect(SqlSession session, String gCode) {
		GoodsDTO gDTO = session.selectOne("goodsOneSelect", gCode);
		return gDTO;
	}

}
