package old.DispatcherServlet4.spring.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class UpdateBoardController {

	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardDTO dto, BoardDAO boardDAO) {
		System.out.println("글수정 처리");
		boardDAO.updateBoard(dto);
		return "getBoardList.do";
	}

}
