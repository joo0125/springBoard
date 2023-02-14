package com.goo9.web.user.controller;

import java.io.IOException;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Redirect;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.goo9.web.user.dao.MemberDAO;
import com.goo9.web.user.dto.MemberDTO;
import com.goo9.web.user.model.MemberVO;
import com.goo9.web.user.service.MemberService;

@Controller // 현재 클래스를 스프링에서 관리하는 컨트롤러 bean으로 생성
@RequestMapping("/member/*") // 모든맵핑은 /member/를 상속
public class MemberController {
	// 로깅을 위한 변수
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	MemberService memberService;

	//

	// 01. 로그인 화면
	@RequestMapping("login.do")
	public String login() {
		/* System.out.println("test  /n/n/n/n/n "); */
		return "member/login"; // views/member/login.jsp로 포워드
	}

	// 02. 로그인 처리
	@RequestMapping("loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute MemberVO vo, HttpSession session) {
		boolean result = memberService.loginCheck(vo, session);
		ModelAndView mav = new ModelAndView();
		if (result == true) { // 로그인 성공
			// main.jsp로 이동
			mav =  new ModelAndView("redirect:/board/getBoardList.do"); 
//			mav.setViewName(new Redirect("/board/getBoardList"));
//			mav.addObject("msg", "success");
		} else { // 로그인 실패
			// login.jsp로 이동
			mav.setViewName("member/login");
			mav.addObject("msg", "failure");
		}
		return mav;
	}

	/**
	 * 로그인 처리 (id & pw 데이터 일치 확인 처리) 로그인 성공시 session 처리
	 */
	/*
	 * @RequestMapping(value="/loginCheck.do", method=RequestMethod.POST)
	 * public @ResponseBody Object loginCheck(@RequestBody Map<String, String>
	 * loginMap, HttpServletRequest request, Model model) throws Exception{
	 * 
	 * HttpSession session = request.getSession();
	 * 
	 * // 기존에 user라는 session 값이 존재하면 remove if(session.getAttribute("userId") != ){
	 * session.removeAttribute("userId"); }
	 * 
	 * try{
	 * 
	 * MemberDTO userDto = MemberDAO.loginCheck();
	 * 
	 * 
	 * 
	 * 
	 * if(userDto != null) { session.setAttribute("userId", userDto);
	 * 
	 * return userDto; } else{ return 0; }
	 * 
	 * } catch(IOException e){ return 9; }
	 * 
	 * }
	 */

	// 03. 로그아웃 처리
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session) {
		memberService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/login");
		mav.addObject("msg", "logout");
		return mav;
	}
	
    // 회원가입 페이지
    @RequestMapping(value = "/register.do", method = RequestMethod.GET)
    public String registerGET() throws Exception {
        return "/member/register";
    }

    // 회원가입 처리
	/*
	 * @RequestMapping(value = "/register_save.do", method = RequestMethod.POST)
	 * public String registerPOST(MemberVO memberVO, RedirectAttributes
	 * redirectAttributes) throws Exception {
	 * 
	 * String hashedPw = BCrypt.hashpw(memberVO.getUserPw(), BCrypt.gensalt());
	 * memberVO.setUserPw(hashedPw); memberService.register(memberVO);
	 * redirectAttributes.addFlashAttribute("msg", "REGISTERED");
	 * 
	 * return "redirect:/member/login"; }
	 */
    
	// 회원가입 post
	@RequestMapping(value = "/register_save.do", method = RequestMethod.POST)
	public String postRegister(MemberVO vo) throws Exception {
		logger.info("post register");
		
		memberService.register(vo);
		
		return "redirect:/member/login.do";
	}
}
