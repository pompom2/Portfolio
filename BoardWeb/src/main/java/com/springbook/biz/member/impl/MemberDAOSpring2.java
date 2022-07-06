package com.springbook.biz.member.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springbook.biz.member.MemberDTO;

//@Repository("memberDAO")
public class MemberDAOSpring2 {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// SQL문
	private final String MEMBER_INSERT = "insert into member values(?, ?, ?, ?)";
	private final String MEMBER_UPDATE = "update member set name=?, role=? where id=? and password=?";
	private final String MEMBER_DELETE = "delete member where id=? and password=?";
	private final String MEMBER_GET = "select * from member where id=? and password=?";
	
	// 회원 등록
	public void insertMember(MemberDTO dto) {
		System.out.println("===> MemberDAOSpring2 - insertMember()");
		jdbcTemplate.update(MEMBER_INSERT, dto.getId(), dto.getPassword(), dto.getName(), dto.getRole());
	}
	
	// 회원 수정
	public void updateMember(MemberDTO dto) {
		System.out.println("===> MemberDAOSpring2 - updateMember()");
		jdbcTemplate.update(MEMBER_UPDATE, dto.getName(), dto.getRole(), dto.getId(), dto.getPassword());
	}
	
	// 회원 삭제
	public void deleteMember(MemberDTO dto) {
		System.out.println("===> MemberDAOSpring2 - deleteMember()");
		jdbcTemplate.update(MEMBER_DELETE, dto.getId(), dto.getPassword());
	}
	
	// 회원정보(1건) 보기
	public MemberDTO getMember(MemberDTO dto) {
		System.out.println("===> MemberDAOSpring2 - getMember()");
		Object[] args = {dto.getId(), dto.getPassword()};
		return jdbcTemplate.queryForObject(MEMBER_GET, args, new MemberRowMapper());
	}
	
	// RowMapper 클래스 생성 - 리턴값을 자바객체와 매핑하는 클래스
	private class MemberRowMapper implements RowMapper<MemberDTO> {
		@Override
		public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberDTO member = new MemberDTO();
			member.setId(rs.getString("id"));
			member.setPassword(rs.getString("password"));
			member.setName(rs.getString("name"));
			member.setRole(rs.getString("role"));
			return member;
		}
	}

}
