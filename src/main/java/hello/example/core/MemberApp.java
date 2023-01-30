package hello.example.core;

import hello.example.core.member.Grade;
import hello.example.core.member.Member;
import hello.example.core.member.MemberService;
import hello.example.core.member.MemberService;
import hello.example.core.member.MemberServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member(1l, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1l);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
