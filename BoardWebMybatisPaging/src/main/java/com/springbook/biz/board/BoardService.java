package com.springbook.biz.board;

import java.util.List;

public interface BoardService {
	
	void insertBoard(BoardDTO dto);
	void updateBoard(BoardDTO dto);
	void deleteBoard(BoardDTO dto);
	void updateBoardCnt(BoardDTO dto);
	BoardDTO getBoard(BoardDTO dto);
	List<BoardDTO> getBoardList(BoardDTO dto, BlockDTO block);
	int getBoardListCount(BoardDTO dto); // 페이징에서 사용할 전체 페이지 수를 구함
}