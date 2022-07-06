package old.DispatcherServlet4.spring.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class GetBoardController {

	@RequestMapping(value="/getBoard.do")
	public ModelAndView getBoard(BoardDTO dto, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글상세 조회");
		mav.addObject("board", boardDAO.getBoard(dto));
		mav.setViewName("getBoard.jsp");
		return mav;
	}

}
