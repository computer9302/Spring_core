package hello.example.core.member;

import hello.example.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;


public class MemberServiceTest {
    MemberService memberService;
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    // 이거 기대값이 다름 오류임 왜 그런지 확인하기
    @Test
    void join(){
        //given
        Member member = new Member(1l, "memberA", Grade.VIP);

        //test할떄 given when then 나오는 단축키 있었음. 찾아보기
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1l);
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
