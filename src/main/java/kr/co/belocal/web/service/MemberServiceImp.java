package kr.co.belocal.web.service;

import kr.co.belocal.web.entity.Member;
import kr.co.belocal.web.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImp implements MemberService{

    @Autowired
    MemberRepository memberRepository;


    @Override
    public Member getById(Integer id) {

        return memberRepository.findById(id);
    }
}//class