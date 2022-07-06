package old.DispatcherServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.member.MemberDTO;
import com.springbook.biz.member.impl.MemberDAO;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트의 요청 정보를 통해 /*.do를 추출
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		//System.out.println("uri: " + uri);
		//System.out.println("path: " + path);
		
		// 2. 추출된 path에 따라 흐름을 제어
		if(path.equals("/login.do")) {
			System.out.println("로그인 처리");
			// 1. 클라이언트의 입력정보 획득
			String id = request.getParameter("id");
			String password = request.getParameter("password");

			// 2. 객체 생성 및 DB 연동
			MemberDTO dto = new MemberDTO();
			dto.setId(id);
			dto.setPassword(password);

			MemberDAO memberDAO = new MemberDAO();
			MemberDTO member = memberDAO.getMember(dto);

			// 3. 화면 이동 제어
			if(member != null) {
				HttpSession session = request.getSession();
				session.setAttribute("memberId", member.getId());
				response.sendRedirect("getBoardList.do");
			} else {
				response.sendRedirect("login.jsp");
			}
		} else if(path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
			// 1. 세션 삭제
			HttpSession session = request.getSession();
			session.invalidate();
			// 2. 화면 이동
			response.sendRedirect("login.jsp");
		} else if(path.equals("/insertBoard.do")) {
			System.out.println("글등록 처리");
			request.setCharacterEncoding("utf-8");
			// 1. 요청 정보 획득
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			// 2. 객체 생성, DB 연동
			BoardDTO dto = new BoardDTO();
			dto.setTitle(title);
			dto.setWriter(writer);
			dto.setContent(content);
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(dto);
			// 3. 화면 이동
			response.sendRedirect("getBoardList.do");
		} else if(path.equals("/updateBoard.do")) {
			System.out.println("글수정 처리");
			request.setCharacterEncoding("utf-8");
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
			response.sendRedirect("getBoardList.do");
		} else if(path.equals("/deleteBoard.do")) {
			System.out.println("글삭제 처리");
			// 1. 요청 정보 획득
			int seq = Integer.parseInt(request.getParameter("seq"));
			// 2. 객체 생성, DB 연동
			BoardDTO dto = new BoardDTO();
			dto.setSeq(seq);
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(dto);
			// 3. 화면 이동
			response.sendRedirect("getBoardList.do");
		} else if(path.equals("/getBoard.do")) {
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
			response.sendRedirect("getBoard.jsp");
		} else if(path.equals("/getBoardList.do")) {
			System.out.println("글목록 조회");
			// 1. DB 연동
			BoardDTO dto = new BoardDTO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardDTO> boardList = boardDAO.getBoardList(dto);
			// 2. 세션 생성, 화면 이동
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
		}
		
	}

}
