package hello.core.member;

public interface MemberRepository {
    /**
     * interface 생성
     * Create save, findById
     */

    void save(Member member);

    Member findById(Long memberId);
}
