

package com.goo9.web.board.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.goo9.web.board.model.BoardVO;
import com.goo9.web.board.model.ReplyVO;
import com.goo9.web.board.service.BoardService;

@Controller

@RequestMapping(value = "/board")

public class BoardController {

	@Inject

	private BoardService boardService;

	@RequestMapping(value = "/getBoardList.do", method = RequestMethod.GET)

	public ModelAndView getBoardList(Model model, HttpSession session) throws Exception {
		model.addAttribute("boardList", boardService.getBoardList());
		ModelAndView mav = new ModelAndView();
		mav.addObject(model);
		mav.setViewName("board/list");
		return mav;

	}
	
	@RequestMapping(value = "/getBoardForm.do", method = RequestMethod.GET)
	public String insertBoard(Model model) throws Exception {

//		model.addAttribute("insertBoard", boardService.insertBoard());
		return "board/boardForm";

	}
	

	@RequestMapping(value = "/saveBoard.do", method = RequestMethod.POST)

	public String saveBoard(@ModelAttribute("BoardVO") BoardVO boardVO

			, RedirectAttributes rttr) throws Exception {

		boardService.insertBoard(boardVO);

		return "redirect:getBoardList.do";

	}

	@RequestMapping(value = "/boardContent.do", method = RequestMethod.GET)

	public String getBoardContent(Model model,HttpSession session, @RequestParam("bid") int bid) throws Exception {
		String userId = (String) session.getAttribute("userId");
		 
		model.addAttribute("boardContent", boardService.getBoardContent(bid));		
//		ReplyVO replyVo = new ReplyVO();
//		List<ReplyVO> replyVo = new ArrayList<ReplyVO>();
//		model.addAttribute("replyVO", replyVo);
		model.addAttribute("replyVO", boardService.getReplyList(bid));

		return "board/boardContent";

	}
	
	@RequestMapping(value = "/updateForm.do", method = RequestMethod.GET)

	public String updateBoard(Model model, @RequestParam("bid") int bid) throws Exception {
		
		model.addAttribute("boardContent", boardService.getBoardContent(bid));

		return "board/updateForm";

	}
	
	@RequestMapping(value = "/saveupdate.do", method = RequestMethod.GET)

	public String saveUpdate(@ModelAttribute("BoardVO") BoardVO boardVO

			, RedirectAttributes rttr) throws Exception {
		boardService.updateBoard(boardVO);

		return "redirect:getBoardList.do";   

	}
	
	@RequestMapping(value = "/deleteForm.do", method = RequestMethod.GET)

	public String deleteBoard(@RequestParam("bid") int bid, HttpSession session,@RequestParam("reg_id") String reg_id ) throws Exception {
		
		System.out.println("regId : "+reg_id);
		System.out.println(session.getAttribute("userName"));
		String boardId = reg_id;
		String uId = (String)session.getAttribute("userName");
		
		boardService.deleteBoard(bid, boardId, uId);
		// 모델앤 뷰에 redirect:getBoardList.do 이거랑 Y N 담아보내주고 c:if Y 이면 버튼 보이게 
		return "redirect:getBoardList.do";
		
	} 
	

}
