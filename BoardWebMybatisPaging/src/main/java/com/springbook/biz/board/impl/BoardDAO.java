package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.common.JDBCUtil;

//@Repository("boardDAO")
public class BoardDAO {
	// DB 연결, 질의 객체
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// SQL문
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values (board_seq.nextval, ?, ?, ?)";
	private final String BOARD_LIST = "select * from board order by seq desc";
	private final String BOARD_GET = "select * from board where seq = ?";
	private final String BOARD_UPDATE = "update board set title=?, content=?, writer=?, uploadFile=? where seq=?";
	private final String BOARD_DELETE = "delete board where seq = ?";
	private final String BOARD_UPDATE_CNT = "update board set cnt=cnt+1 where seq=?";
	// 검색 기능 SQL문 - TITLE, CONTENT, WRITER
	private final String BOARD_LIST_TITLE = "select * from board where title like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_CONTENT = "select * from board where content like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_WRITER = "select * from board where writer like '%'||?||'%' order by seq desc";

	// 글등록
	public void insertBoard(BoardDTO dto) {
		System.out.println("=> JDBC로 insertBoard() 실행");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getContent());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	// 글전체 보기 -> 검색 기능 추가
	public List<BoardDTO> getBoardList(BoardDTO dto) {
		System.out.println("=> JDBC로 getBoardList() 실행");
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		try {
			conn = JDBCUtil.getConnection();
			//pstmt = conn.prepareStatement(BOARD_LIST);
			
			if(dto.getSearchCondition().equals("TITLE")) {
				pstmt = conn.prepareStatement(BOARD_LIST_TITLE);
			} else if(dto.getSearchCondition().equals("CONTENT")) {
				pstmt = conn.prepareStatement(BOARD_LIST_CONTENT);
			} else if(dto.getSearchCondition().equals("WRITER")) {
				pstmt = conn.prepareStatement(BOARD_LIST_WRITER);
			}
			pstmt.setString(1, dto.getSearchKeyword());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getTimestamp("regdate"));
				board.setCnt(rs.getInt("cnt"));
				boardList.add(board);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return boardList;
	}
	
	// 글상세 보기(1건)
	public BoardDTO getBoard(BoardDTO dto) {
		System.out.println("=> JDBC로 getBoard() 실행");
		BoardDTO board = null;
		try {
			// 조회수 증가 메소드 호출
			updateBoardCnt(dto);
			
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, dto.getSeq());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board = new BoardDTO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getTimestamp("regdate"));
				board.setCnt(rs.getInt("cnt"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return board;
	}
	
	// 조회수 증가 -> 글상세보기에서 처리
	public void updateBoardCnt(BoardDTO dto) {
		System.out.println("=> JDBC로 updateBoardCnt() 실행");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE_CNT);
			pstmt.setInt(1, dto.getSeq());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	// 글수정
	public void updateBoard(BoardDTO dto) {
		System.out.println("=> JDBC로 updateBoard() 실행");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getWriter());
			pstmt.setInt(4, dto.getSeq());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	// 글삭제
	public void deleteBoard(BoardDTO dto) {
		System.out.println("=> JDBC로 deleteBoard() 실행");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, dto.getSeq());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
}
