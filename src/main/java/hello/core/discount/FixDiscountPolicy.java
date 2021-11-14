package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

/**
 * DiscountPolicy 구현체
 * 정액 할인 금액
 */
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;   // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
