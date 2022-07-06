package old.DispatcherServlet3.spring.xml;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.member.MemberDTO;
import com.springbook.biz.member.impl.MemberDAO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		// ModelAndView 클래스 - 모델과 뷰를 함께 저장하는 클래스
		// redirect: - ViewResolver를 무시하고 리다이렉트를 실행
		ModelAndView mav = new ModelAndView();
		if(member != null) {
			mav.addObject("memberId", member.getId());
			mav.setViewName("redirect:getBoardList.do");
		} else {
			mav.setViewName("redirect:login.jsp");
		}
		return mav;
	}

}
