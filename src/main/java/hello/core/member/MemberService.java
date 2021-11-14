package hello.core.member;

public interface MemberService {
    /**
     * create memberservice interface
     * join, findMember
     */

    void join(Member member);

    Member findMember(Long memberId);
}
