package old.DispatcherServlet2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;

public class DeleteBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글삭제 처리");
		// 1. 요청 정보 획득
		int seq = Integer.parseInt(request.getParameter("seq"));
		// 2. 객체 생성, DB 연동
		BoardDTO dto = new BoardDTO();
		dto.setSeq(seq);
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(dto);
		// 3. 화면 이동
		return "getBoardList.do";
	}

}
