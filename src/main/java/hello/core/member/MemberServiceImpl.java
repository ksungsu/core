package hello.core.member;

public class MemberServiceImpl implements MemberService{

    /**
     * memberService 구현체
     */

//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 관심사 분리(생성자 주입)(DI)
     */
    private final MemberRepository memberRepository;

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
}
