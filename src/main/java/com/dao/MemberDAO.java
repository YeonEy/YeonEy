package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {

	public int memberInsert(SqlSession session, MemberDTO dto) {
		int num = session.insert("memberInsert", dto);
		return num;
	}

	public int memberInsert(SqlSession session, String userid) {
		int num = session.selectOne("idCheck", userid);
		return num;
	}

	public MemberDTO login(SqlSession session, Map<String, String> map) {
		MemberDTO dto = session.selectOne("selectMember", map);
		return dto;
	}

	public MemberDTO mypage(SqlSession session, String userid) {
		MemberDTO dto = session.selectOne("mypage", userid);
		return dto;
	}

	public int memberUpdate(SqlSession session, MemberDTO dto) {
		int num = session.update("memberUpdate", dto);
		return num;
	}


}
