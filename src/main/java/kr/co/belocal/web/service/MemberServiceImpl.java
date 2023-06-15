package kr.co.belocal.web.service;

import kr.co.belocal.web.entity.Member;
import kr.co.belocal.web.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    //아이디 찾기
    @Override
    public String getListByFindId(String phoneNum) {
        return memberRepository.findId(phoneNum);
    }

    //비밀번호 찾기
    @Override
    public String getListByFindId(String userId, String phoneNum) {
        return memberRepository.findPw(userId,phoneNum);
    }


    //회원가입
    @Override
    public void save(Member member) {
        member.setPw(passwordEncoder.encode(member.getPw()));
        memberRepository.save(member);
    }


    //로그인
    @Override
    public boolean login(Member member) {
        Member info = memberRepository.login(member);

        //일치하는 계정이 존재한다면
        if (info!=null)
            if (passwordEncoder.matches(member.getPw(),info.getPw()))
                return true;

        return false;
    }



    //아이디 중복 확인
    @Override
    public String checkId(String userId) {
        return memberRepository.checkId(userId);
    }

    //닉네임 중복 확인
    @Override
    public String checkNickName(String nickName) {
        return memberRepository.checkNickName(nickName);
    }


}//class
