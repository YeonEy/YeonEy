package com.service;

import java.sql.SQLFeatureNotSupportedException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.MemberDAO;
import com.dto.MemberDTO;

public class MemberService {
	
	MemberDAO dao;

	public MemberService() {
		super();
		dao = new MemberDAO();
	}

	public int memberInsert(MemberDTO dto) {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSqlSession();
		try {
			num = dao.memberInsert(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}

	public int idCheck(String userid) {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSqlSession();
		try {
			num = dao.memberInsert(session, userid);
		} finally {
			session.close();
		}
		return num;
	}

	public MemberDTO login(String userid, String passwd) {
		MemberDTO dto = null;
		SqlSession session = MySqlSessionFactory.getSqlSession();
		Map<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		try {
			dto = dao.login(session, map);
		} finally {
			session.close();
		}
		return dto;
	}

	public MemberDTO mypage(String userid) {
		MemberDTO dto = null;
		SqlSession session = MySqlSessionFactory.getSqlSession();
		try {
			dto = dao.mypage(session, userid);
		} finally {
			session.close();
		}
		return dto;
	}

	public int memberUpdate(MemberDTO dto) {
		int num = 0;
		SqlSession session = MySqlSessionFactory.getSqlSession();
		try {
			num = dao.memberUpdate(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return num;
	}


}
