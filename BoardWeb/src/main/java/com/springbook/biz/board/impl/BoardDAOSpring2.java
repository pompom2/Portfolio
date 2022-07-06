package com.springbook.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardDTO;

@Repository("boardDAO")
public class BoardDAOSpring2 {
	// SQL문
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values (board_seq.nextval, ?, ?, ?)";
	//private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values (?, ?, ?, ?)"; // 트랙잭션 테스트
	private final String BOARD_LIST = "select * from board order by seq desc";
	private final String BOARD_GET = "select * from board where seq = ?";
	private final String BOARD_UPDATE = "update board set title=?, content=?, writer=?, uploadFile=? where seq=?";
	private final String BOARD_DELETE = "delete board where seq = ?";
	private final String BOARD_UPDATE_CNT = "update board set cnt=cnt+1 where seq=?";
	// 검색 기능 SQL문 - TITLE, CONTENT, WRITER
	private final String BOARD_LIST_TITLE = "select * from board where title like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_CONTENT = "select * from board where content like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_WRITER = "select * from board where writer like '%'||?||'%' order by seq desc";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 글등록
	public void insertBoard(BoardDTO dto) {
		System.out.println("===> BoardDAOSpring2 - insertBoard()");
		jdbcTemplate.update(BOARD_INSERT, dto.getTitle(), dto.getWriter(), dto.getContent());
		//jdbcTemplate.update(BOARD_INSERT, dto.getSeq(), dto.getTitle(), dto.getWriter(), dto.getContent()); // 트랜잭션 테스트
	}
	
	// 글수정
	public void updateBoard(BoardDTO dto) {
		System.out.println("===> BoardDAOSpring2 - updateBoard()");
		jdbcTemplate.update(BOARD_UPDATE, dto.getTitle(), dto.getContent(), dto.getWriter(), dto.getUploadFile().getOriginalFilename(), dto.getSeq());
	}
	
	// 글삭제
	public void deleteBoard(BoardDTO dto) {
		System.out.println("===> BoardDAOSpring2 - deleteBoard()");
		jdbcTemplate.update(BOARD_DELETE, dto.getSeq());
	}
	
	// 글전체 보기 -> 검색 기능 추가
	public List<BoardDTO> getBoardList(BoardDTO dto) {
		System.out.println("===> BoardDAOSpring2 - getBoardList()");
		//return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
		
		Object[] args = {dto.getSearchKeyword()};
		if(dto.getSearchCondition().equals("TITLE")) {
			return jdbcTemplate.query(BOARD_LIST_TITLE, args, new BoardRowMapper());
		} else if(dto.getSearchCondition().equals("CONTENT")) {
			return jdbcTemplate.query(BOARD_LIST_CONTENT, args, new BoardRowMapper());
		} else if(dto.getSearchCondition().equals("WRITER")) {
			return jdbcTemplate.query(BOARD_LIST_WRITER, args, new BoardRowMapper());
		} 
		return null;
	}
	
	// 조회수 증가 -> 글상세보기에서 동작
	public void updateBoardCnt(BoardDTO dto) {
		System.out.println("===> BoardDAOSpring2 - updateBoardCnt()");
		jdbcTemplate.update(BOARD_UPDATE_CNT, dto.getSeq());
	}
	
	// 글상세 보기(1건)
	public BoardDTO getBoard(BoardDTO dto) {
		System.out.println("===> BoardDAOSpring2 - getBoard()");
		Object[] args = {dto.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	
	// RowMapper 클래스 생성 - 리턴값을 자바객체와 매핑하는 클래스
	private class BoardRowMapper implements RowMapper<BoardDTO> {
		@Override
		public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardDTO board = new BoardDTO();
			board.setSeq(rs.getInt("seq"));
			board.setTitle(rs.getString("title"));
			board.setWriter(rs.getString("writer"));
			board.setContent(rs.getString("content"));
			board.setRegdate(rs.getTimestamp("regdate"));
			board.setCnt(rs.getInt("cnt"));
			return board;
		}
	}
	
}
