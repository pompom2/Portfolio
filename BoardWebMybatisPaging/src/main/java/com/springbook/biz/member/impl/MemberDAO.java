package com.springbook.biz.member.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.member.MemberDTO;

//@Repository("memberDAO")
public class MemberDAO {
	
	// DB 연결, 질의 변수
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// SQL문
	private final String MEMBER_INSERT = "insert into member(id, password, name, email, tel, address) values(?, ?, ?, ?, ?, ?)";
	private final String MEMBER_UPDATE = "update member set password=?, name=?, email=?, tel=?, address=? where id=? ";
	private final String MEMBER_DELETE = "delete member where id=? and password=?";
	private final String MEMBER_GET = "select * from member where id=? and password=?";
	
	// 회원 등록
	public void insertMember(MemberDTO dto) {
		System.out.println("=> insertMember() 메소드 실행");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(MEMBER_INSERT);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getTel());
			pstmt.setString(6, dto.getAddress());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	// 회원 수정
	public void updateMember(MemberDTO dto) {
		System.out.println("=> updateMember() 메소드 실행");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(MEMBER_UPDATE);
			pstmt.setString(1, dto.getPassword());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getAddress());
			pstmt.setString(6, dto.getId());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	// 회원 삭제
	public void deleteMember(MemberDTO dto) {
		System.out.println("=> deleteMember() 메소드 실행");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(MEMBER_DELETE);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	// 회원정보(1건) 보기
	public MemberDTO getMember(MemberDTO dto) {
		System.out.println("=> getMember() 메소드 실행");
		MemberDTO member = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(MEMBER_GET);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberDTO();
				member.setId(rs.getString("id"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setTel(rs.getString("tel"));
				member.setAddress(rs.getString("address"));
				member.setRegdate(rs.getTimestamp("regdate"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return member;
	}
	
}
