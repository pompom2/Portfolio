package com.springbook.view.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.member.MemberDTO;
import com.springbook.biz.member.MemberService;

@Controller
public class LogonController {
	
	@Autowired
	private MemberService memberService;

	// 로그인 처리(폼으로 화면이동) -> GET
	//@RequestMapping(value="/login.do", method=RequestMethod.GET)
	@GetMapping(value="/login.do")
	public String login() {
		System.out.println("=> LogonController - 로그인 화면이동");
		return "login.jsp";
	}
	
	// 로그인 처리(DB 처리) -> POST
	//@RequestMapping(value="/login.do", method=RequestMethod.POST)
	@PostMapping(value="/login.do")
	public String login(MemberDTO dto, HttpSession session) {
		System.out.println("=> LogonController - 로그인 처리(DB 처리)");
		
		// 아이디를 입력하지 않았을 때 예외 발생
		if(dto.getId() == null || dto.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다!");
		}
		
		// 비밀번호를 입력하지 않았을 때 예외 발생
		if(dto.getPassword() == null || dto.getPassword().equals("")) {
			throw new IllegalArgumentException("비밀번호는 반드시 입력해야 합니다!");
		}
		
		MemberDTO member = memberService.getMember(dto);
		if(member != null) {
			session.setAttribute("memberId", member.getId());
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		System.out.println("=> LogonController - 로그아웃 처리");
		session.invalidate();
		return "login.do";
	}
}
