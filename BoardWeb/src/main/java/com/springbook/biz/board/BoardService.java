package com.springbook.biz.board;

import java.util.List;

public interface BoardService {
	
	void insertBoard(BoardDTO dto);
	void updateBoard(BoardDTO dto);
	void deleteBoard(BoardDTO dto);
	List<BoardDTO> getBoardList(BoardDTO dto);
	void updateBoardCnt(BoardDTO dto);
	BoardDTO getBoard(BoardDTO dto);

}
