package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * OrderService 구현체
 * 단일-책임의 원칙을 준수.
 * 역할과 구현을 잘 분리함.
 */
@Component
@RequiredArgsConstructor // final 변수 생성자를 자동 생성
public class OrderServiceImpl implements OrderService{


    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //test 용도, (MemberServerviceImpl과 OrderServiceImple의 singleton 객체 참조테스트)
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
