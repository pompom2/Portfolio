package com.springbook.biz.board.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BlockDTO;
import com.springbook.biz.board.BoardDTO;

@Repository("boardDAO")
public class BoardDAOMybatis2 {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 글등록
	public void insertBoard(BoardDTO dto) {
		System.out.println("===> BoardDAOMybatis2 - insertBoard()");
		mybatis.insert("BoardDAO.insertBoard", dto);
	}
	
	// 글수정
	public void updateBoard(BoardDTO dto) {
		System.out.println("===> BoardDAOMybatis2 - updateBoard()");
		mybatis.update("BoardDAO.updateBoard", dto);
	}
	
	// 글삭제
	public void deleteBoard(BoardDTO dto) {
		System.out.println("===> BoardDAOMybatis2 - deleteBoard()");
		mybatis.delete("BoardDAO.deleteBoard", dto);
	}
	
	// 조회수 증가 -> 글상세보기에서 동작
	public void updateBoardCnt(BoardDTO dto) {
		System.out.println("===> BoardDAOMybatis2 - updateBoardCnt()");
		mybatis.update("BoardDAO.updateBoardCnt", dto);
	}
	
	// 글상세 보기(1건)
	public BoardDTO getBoard(BoardDTO dto) {
		System.out.println("===> BoardDAOMybatis2 - getBoard()");
		return mybatis.selectOne("BoardDAO.getBoard", dto);
	}
	
	// 페이징 처리에서 전체 페이지 수를 구함
	public int getBoardListCount(BoardDTO dto) {
		System.out.println("===> BoardDAOMybatis2 - getBoardListCount()");
		return mybatis.selectOne("BoardDAO.getBoardListCount", dto);
	}
	
	// 글전체 보기 -> 검색 기능 추가
	public List<BoardDTO> getBoardList(BoardDTO dto, BlockDTO block) {
		System.out.println("===> BoardDAOMybatis2 - getBoardList()");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("board", dto);
		block.setStartNum((block.getPageNum() - 1) * block.getAmount());
		map.put("block", block);
		
		return mybatis.selectList("BoardDAO.getBoardList", map);
		
	}
	
	// 글 삭제 - 회원 탈퇴 시, 게시글 전부 삭제(트랜잭션 처리)
	public void deleteBoardById(BoardDTO dto) {
		System.out.println("===> BoardDAOMybatis2 - deleteBoardById()");
		mybatis.delete("BoardDAO.deleteBoardById", dto);
	}
}
