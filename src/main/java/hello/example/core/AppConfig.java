package hello.example.core;

import hello.example.core.discount.DiscountPolicy;
import hello.example.core.discount.FixDiscountPolicy;
import hello.example.core.discount.RateDiscountPolicy;
import hello.example.core.member.MemberRepository;
import hello.example.core.member.MemberService;
import hello.example.core.member.MemberServiceImpl;
import hello.example.core.member.MemoryMemberRepository;
import hello.example.core.order.OrderService;
import hello.example.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(MemberRepository());
    }
    @Bean
    public MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() { return new RateDiscountPolicy();
    }
}