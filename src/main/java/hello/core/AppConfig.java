package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* @Configuration : 애플리케이션의 구성 정보를 담당
* @Bean : 스프링 빈으로 등록
* */
@Configuration
public class AppConfig {

    /*
    * 구현 클래스 분리 - 중복 코드를 방지
    * */
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    /*
     * 역할 클래스 분리
     * */
    // MemberService를 만들고 MemoryMemberRepository를 사용할거야 ~
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    /*
    * 전체 구성요소를 빠르게 파악할 수 있다.
    * 역할과 구현을 분리하여 중복을 제거할 수 있다.
    * */

}
