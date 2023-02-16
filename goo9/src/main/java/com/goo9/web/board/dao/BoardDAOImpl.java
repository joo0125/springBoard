package com.goo9.web.board.dao;

import java.util.List;



import javax.inject.Inject;



import org.apache.ibatis.session.SqlSession;

import org.springframework.stereotype.Repository;



import com.goo9.web.board.model.BoardVO;
import com.goo9.web.board.model.ReplyVO;



@Repository

public class BoardDAOImpl implements BoardDAO {

	

	@Inject

	private SqlSession sqlSession;



	@Override

	public List<BoardVO> getBoardList() throws Exception {

		return sqlSession.selectList("com.goo9.web.board.boardMapper.getBoardList");

	}



	@Override

	public BoardVO getBoardContent(int bid) throws Exception {

		return sqlSession.selectOne("com.goo9.web.board.boardMapper.getBoardContent", bid);

	}



	@Override

	public int insertBoard(BoardVO boardVO) throws Exception {

		return sqlSession.insert("com.goo9.web.board.boardMapper.insertBoard", boardVO);

	}



	@Override

	public int updateBoard(BoardVO boardVO) throws Exception {

		return sqlSession.update("com.goo9.web.board.boardMapper.updateBoard", boardVO);

	}



	@Override

	public int deleteBoard(int bid) throws Exception {

		return sqlSession.delete("com.goo9.web.board.boardMapper.deleteBoard", bid);

	}



	@Override

	public int updateViewCnt(int bid) throws Exception {

		return sqlSession.update("com.goo9.web.board.boardMapper.updateViewCnt", bid);

	}
	
	  // 댓글 리스트

		@Override

		public List<ReplyVO> getReplyList(int bid) throws Exception {

			return sqlSession.selectList("com.goo9.web.board.replyMapper.getReplyList", bid);

		}



		@Override

		public int saveReply(ReplyVO replyVO) throws Exception {

			return sqlSession.insert("com.goo9.web.board.replyMapper.saveReply", replyVO);

		}



		@Override

		public int updateReply(ReplyVO replyVO) throws Exception {

			return sqlSession.update("com.goo9.web.board.replyMapper.updateReply", replyVO);

		}



		@Override

		public int deleteReply(int rid) throws Exception {

			return sqlSession.delete("com.goo9.web.board.replyMapper.deleteReply", rid);

		}


//
//		@Override
//		public int saveReply(ReplyVO replyVO) throws Exception {
//			// TODO Auto-generated method stub
//			return 0;
//		}
//
//
//
//		@Override
//		public int updateReply(ReplyVO replyVO) throws Exception {
//			// TODO Auto-generated method stub
//			return 0;
//		}

	

}