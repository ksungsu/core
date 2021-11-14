package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    /**
     * Junit을 사용한 테스트 작성
     * join
     */
    @Test
    void join(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);

        assertEquals(member.getName(),"memberA");
        assertEquals(member.getGrade(), Grade.VIP);
//        org.junit.jupiter.api.Assertions.assertEquals(member.getName(),"memberA");
        System.out.println("member Name = " + member.getName());
        System.out.println("Grade = " + Grade.VIP);
    }
}
