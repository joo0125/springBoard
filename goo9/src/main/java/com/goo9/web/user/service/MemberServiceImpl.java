package com.goo9.web.user.service;
 
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
 
import org.springframework.stereotype.Service;
 
import com.goo9.web.user.dao.MemberDAO;
import com.goo9.web.user.model.MemberVO;
 
@Service // 현재 클래스를 스프링에서 관리하는 service bean으로 등록
public class MemberServiceImpl implements MemberService {
    
    @Inject
    MemberDAO memberDao;
    
    // 01_01. 회원 로그인체크
    @Override
    public boolean loginCheck(MemberVO vo, HttpSession session) {
        boolean result = memberDao.loginCheck(vo);
        if (result) { // true일 경우 세션에 등록
            MemberVO vo2 = viewMember(vo);
            // 세션 변수 등록
            session.setAttribute("userId", vo2.getUserId());
            session.setAttribute("userName", vo2.getUserName());
        } 
        return result;
    }
    // 01_02. 회원 로그인 정보
    @Override
    public MemberVO viewMember(MemberVO vo) {
        return memberDao.viewMember(vo);
    }
    // 02. 회원 로그아웃
    @Override
    public void logout(HttpSession session) {
        // 세션 변수 개별 삭제rr
        // session.removeAttribute("userId");
        // 세션 정보 를 초기화 시킴
        session.invalidate();
    }
    
    //회원가입
	@Override
	public void register(MemberVO vo) throws Exception {
		
		memberDao.register(vo);
	}
}
