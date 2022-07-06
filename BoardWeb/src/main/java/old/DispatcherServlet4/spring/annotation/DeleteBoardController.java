package old.DispatcherServlet4.spring.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class DeleteBoardController {

	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardDTO dto, BoardDAO boardDAO) {
		System.out.println("글삭제 처리");
		boardDAO.deleteBoard(dto);
		return "getBoardList.do";
	}

}
