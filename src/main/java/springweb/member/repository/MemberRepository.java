package springweb.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springweb.member.entity.MemberEntity;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    // [1] 아이디로 엔티티 찾기
    Optional<MemberEntity> findByMid(String mid );
    // vs
    // @Query(value = "select * from member where mid = :mid",nativeQuery = true)
    // MemberEntity query(String mid);
}
