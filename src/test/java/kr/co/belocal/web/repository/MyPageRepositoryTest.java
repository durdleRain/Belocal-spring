package kr.co.belocal.web.repository;

import kr.co.belocal.web.entity.Member;
import kr.co.belocal.web.entity.TravelTheme;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MyPageRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MyPageRepository myPageRepository;

    @Test
    void findAll() {
        List<Member> list = memberRepository.findAll(4);
        System.out.println("list = " + list);
    }

    @Test
    void themeList() {
        List<TravelTheme> list = myPageRepository.themeList(15);
        System.out.println("list = " + list);
    }
}