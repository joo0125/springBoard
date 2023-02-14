package com.goo9.web.board.service;

import java.util.List;

import java.util.Map;



import com.goo9.web.board.model.BoardVO;
import com.goo9.web.board.model.ReplyVO;



public interface BoardService {



	public List<BoardVO> getBoardList() throws Exception;
	
	public void insertBoard(BoardVO boardVO) throws Exception;
	
	public void updateBoard(BoardVO boardVO) throws Exception;
	
	public int deleteBoard(int bid) throws Exception;
	
	public BoardVO getBoardContent(int bid) throws Exception;
	  // 댓글 리스트

		public List<ReplyVO> getReplyList(int bid) throws Exception;

		

		public int saveReply(ReplyVO replyVO) throws Exception;

		

		public int updateReply(ReplyVO replyVO) throws Exception;

		

		public int deleteReply(int rid) throws Exception;	

}