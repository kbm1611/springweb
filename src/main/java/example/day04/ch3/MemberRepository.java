package example.day04.ch3;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 1. 인터페이스 위에 @Repository 붙인다.
    // 2. JpaRepository로부터 상속받는다.
    // 3. JpaRepository< 매핑클래스명, pk타입 >
    // * < > 제네릭타입
}
