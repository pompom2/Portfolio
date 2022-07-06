package old.DispatcherServlet2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글상세 조회");
		// 1. 요청 정보 획득
		int seq = Integer.parseInt(request.getParameter("seq"));
		// 2. 객체 생성, DB 연동
		BoardDTO dto = new BoardDTO();
		dto.setSeq(seq);
		BoardDAO boardDAO = new BoardDAO();
		BoardDTO board = boardDAO.getBoard(dto);
		// 3. 화면 이동
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		return "getBoard";
	}

}
