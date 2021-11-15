package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

/**
 * 정률 Discount 구현체 생성
 */

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
