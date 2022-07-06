package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAOSpring2 boardDAO;
	
	@Override
	@Transactional("txManager")
	public void insertBoard(BoardDTO dto) {
		System.out.println("==> BoardServiceImpl - insertBoard()");
		// 예외 발생 - AfterThrowing 테스트
//		if(dto.getWriter().equals("홍길동")) {
//			throw new IllegalArgumentException("홍길동은 글을 등록할 수 없습니다.");
//		}
		
		boardDAO.insertBoard(dto);
		
		// 트랜잭션 테스트
		
		  dto.setSeq(101); 
		  boardDAO.insertBoard(dto); 
		  dto.setSeq(102);
		  boardDAO.insertBoard(dto);
		 
		
	}

	@Override
	public void updateBoard(BoardDTO dto) {
		System.out.println("==> BoardServiceImpl - updateBoard()");
		boardDAO.updateBoard(dto);
	}

	@Override
	public void deleteBoard(BoardDTO dto) {
		System.out.println("==> BoardServiceImpl - deleteBoard()");
		boardDAO.deleteBoard(dto);
	}
	
	@Override
	public List<BoardDTO> getBoardList(BoardDTO dto) {
		System.out.println("==> BoardServiceImpl - getBoardList()");
		return boardDAO.getBoardList(dto);
	}
	
	@Override
	public void updateBoardCnt(BoardDTO dto) {
		System.out.println("==> BoardServiceImpl - updateBoardCnt()");
		boardDAO.updateBoardCnt(dto);
	}

	@Override
	public BoardDTO getBoard(BoardDTO dto) {
		System.out.println("==> BoardServiceImpl - getBoard()");
		updateBoardCnt(dto);
		return boardDAO.getBoard(dto);
	}

}
