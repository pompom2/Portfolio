package old.DispatcherServlet4.spring.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;

/*
Command 객체 - 요청한 정보를 해당 메소드의 매개변수의 객체를 생성하여 프로퍼티로 넣어주는 객체
*/

@Controller
public class InsertBoardController {

	@RequestMapping(value="/insertBoard.do")
	public String insertMethod(BoardDTO dto, BoardDAO boardDAO) {
		System.out.println("글등록 처리");
		boardDAO.insertBoard(dto);
		return "getBoardList.do";
	}

}
