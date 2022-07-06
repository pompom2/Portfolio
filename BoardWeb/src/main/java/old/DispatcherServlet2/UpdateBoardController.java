package old.DispatcherServlet2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;

public class UpdateBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글수정 처리");
		// 1. 요청 정보 획득
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// 2. 객체 생성, DB 연동
		BoardDTO dto = new BoardDTO();
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setContent(content);
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.updateBoard(dto);
		// 3. 화면 이동
		return "getBoardList.do";
	}

}
