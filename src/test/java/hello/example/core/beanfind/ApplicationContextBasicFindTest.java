package hello.example.core.beanfind;

import hello.example.core.AppConfig;
import hello.example.core.member.Member;
import hello.example.core.member.MemberService;
import hello.example.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

   AnnotationConfigApplicationContext ac =  new AnnotationConfigApplicationContext(AppConfig.class);

   @Test
   @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
       MemberService memberService = ac.getBean("memberService", MemberService.class);
       assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
   }

   @Test
   @DisplayName("이름 없이 타입만으로 조회")
   void findBeanByType(){
      MemberService memberService = ac.getBean(MemberService.class);
      assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
   }

   // 구체 타입으로 하는 것은 좋지 못하다. 왜냐하면 추상에 의존해야 하기 때문이다.
   @Test
   @DisplayName("구체 타입으로 조회")
   void findBeanByName2(){
      MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
      assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
   }

   @Test
   @DisplayName("빈 이름으로 조회x")
   void findBeanByNamex(){
      //ac.getBean("xxxx", MemberService.class);
      assertThrows(NoSuchBeanDefinitionException.class, ()->
              ac.getBean("xxxx", MemberService.class));
   }
}
