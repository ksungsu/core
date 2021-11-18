package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    /**
     * memberService 구현체
     */

//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 관심사 분리(생성자 주입)(DI)
     */
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //test 용도, (MemberServerviceImpl과 OrderServiceImple의 singleton 객체 참조테스트)
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
