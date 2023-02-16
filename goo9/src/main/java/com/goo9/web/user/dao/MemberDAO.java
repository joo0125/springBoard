package com.goo9.web.user.dao;
 
import javax.servlet.http.HttpSession;
import com.goo9.web.user.model.MemberVO;
 
public interface MemberDAO {
    // 01_01. 회원 로그인 체크
    public boolean loginCheck(MemberVO vo);
    // 01_02. 회원 로그인 정보
    public MemberVO viewMember(MemberVO vo);
    // 02. 회원 로그아웃
    public void logout(HttpSession session);
    
	// 회원가입
	public void register(MemberVO vo) throws Exception;
}