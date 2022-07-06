package old.DispatcherServlet3.spring.xml;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("글상세 조회");
		// 1. 요청 정보 획득
		int seq = Integer.parseInt(request.getParameter("seq"));
		// 2. 객체 생성, DB 연동
		BoardDTO dto = new BoardDTO();
		dto.setSeq(seq);
		BoardDAO boardDAO = new BoardDAO();
		BoardDTO board = boardDAO.getBoard(dto);
		// 3. 화면 이동
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("getBoard");
		return mav;
	}

}
