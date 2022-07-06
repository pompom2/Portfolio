package old.DispatcherServlet4.spring.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.member.MemberDTO;
import com.springbook.biz.member.impl.MemberDAO;

@Controller
public class LoginController {

	@RequestMapping(value="/login.do")
	public String login(MemberDTO dto, MemberDAO memberDAO) {
		System.out.println("로그인 처리");
		if(memberDAO.getMember(dto) != null) return "getBoardList.do";
		else return "login.jsp";
	}

}
