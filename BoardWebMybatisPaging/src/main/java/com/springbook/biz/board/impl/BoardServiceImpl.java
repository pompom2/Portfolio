package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BlockDTO;
import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAOMybatis2 boardDAO;
	
	@Override
	public void insertBoard(BoardDTO dto) {
		System.out.println("==> BoardServiceImpl - insertBoard()");
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
	
	@Override
	public List<BoardDTO> getBoardList(BoardDTO dto, BlockDTO block) {
		System.out.println("==> BoardServiceImpl - getBoardList()");
		return boardDAO.getBoardList(dto, block);
	}

	@Override
	public int getBoardListCount(BoardDTO dto) {
		System.out.println("==> BoardServiceImpl - getBoardListCount()");
		return boardDAO.getBoardListCount(dto);
	}
	
	

}
