package com.goo9.web.board.dao;

import java.util.List;



import com.goo9.web.board.model.BoardVO;
import com.goo9.web.board.model.ReplyVO;



public interface BoardDAO {



	public List<BoardVO> getBoardList() throws Exception;

	

	public BoardVO getBoardContent(int bid) throws Exception;

	

	public int insertBoard(BoardVO boardVO) throws Exception;

	

	public int updateBoard(BoardVO boardVO) throws Exception;

	

	public int deleteBoard(int bid) throws Exception;

	

	public int updateViewCnt(int bid) throws Exception;
	
	// 댓글 리스트

	public List<ReplyVO> getReplyList(int bid) throws Exception;

	

	public int saveReply(ReplyVO replyVO) throws Exception;

	

	public int updateReply(ReplyVO replyVO) throws Exception;

	

	public int deleteReply(int rid) throws Exception;

}