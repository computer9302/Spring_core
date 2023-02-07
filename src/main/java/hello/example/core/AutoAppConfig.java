package hello.example.core;


import hello.example.core.member.MemberRepository;
import hello.example.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = Configuration.class))
public class AutoAppConfig {

    /*
        @Bean(name = "memoryMemberRepository")
        public MemberRepository memberRepository(){
            return new MemoryMemberRepository();
        }
        */


}
