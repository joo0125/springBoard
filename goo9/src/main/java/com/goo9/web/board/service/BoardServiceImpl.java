package com.goo9.web.board.service;

import java.util.List;



import javax.inject.Inject;



import org.springframework.stereotype.Service;



import com.goo9.web.board.dao.BoardDAO;

import com.goo9.web.board.model.BoardVO;
import com.goo9.web.board.model.ReplyVO;



@Service

public class BoardServiceImpl implements BoardService{



	@Inject

	private BoardDAO boardDAO;

	

	public List<BoardVO> getBoardList() throws Exception {

		return boardDAO.getBoardList();

	}


	@Override

	public void insertBoard(BoardVO boardVO) throws Exception {

		boardDAO.insertBoard(boardVO);

	}

	
	public BoardVO getBoardContent(int bid) throws Exception{

		boardDAO.updateViewCnt(bid);

		return boardDAO.getBoardContent(bid);

	}
	
	public void updateBoard(BoardVO boardVO) throws Exception {

		boardDAO.updateBoard(boardVO);

	}
	
	public int deleteBoard(int bid) throws Exception {
		
		return boardDAO.deleteBoard(bid);
		
	}
	
	// 댓글 리스트

	@Override

	public List<ReplyVO> getReplyList(int bid) throws Exception {

		return boardDAO.getReplyList(bid);

	}



	@Override

	public int saveReply(ReplyVO replyVO) throws Exception {

		return boardDAO.saveReply(replyVO);

	}



	@Override

	public int updateReply(ReplyVO replyVO) throws Exception {

		return boardDAO.updateReply(replyVO);

	}



	@Override

	public int deleteReply(int rid) throws Exception {

		return boardDAO.deleteReply(rid);

	}


}