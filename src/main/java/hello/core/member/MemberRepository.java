package hello.core.member;

public interface MemberRepository {

    // 구현체의 반환값 / 메소드 명 / 인스턴스
    void save(Member member);

    Member findById(Long memberId);
}
