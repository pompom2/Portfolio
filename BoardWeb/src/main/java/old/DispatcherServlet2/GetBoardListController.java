package old.DispatcherServlet2;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글목록 조회");
		// 1. DB 연동
		BoardDTO dto = new BoardDTO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardDTO> boardList = boardDAO.getBoardList(dto);
		// 2. 세션 생성, 화면 이동
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		return "getBoardList";
	}

}
