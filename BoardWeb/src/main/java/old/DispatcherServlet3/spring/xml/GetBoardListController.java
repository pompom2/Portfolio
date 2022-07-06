package old.DispatcherServlet3.spring.xml;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("글목록 조회");
		// 1. DB 연동
		BoardDTO dto = new BoardDTO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardDTO> boardList = boardDAO.getBoardList(dto);
		// 2. 세션 생성, 화면 이동
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);
		mav.setViewName("getBoardList");
		return mav;
	}

}
