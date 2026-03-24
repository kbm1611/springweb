package springweb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springweb.dto.MemberDto;

@Entity @Table(name = "member")
@NoArgsConstructor @AllArgsConstructor @Data @Builder
public class MemberEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long mno; // 호원번호

    @Column(nullable = false, unique = true ,length = 100)
    private String mid; // 회원 아이디

    @Column(nullable = false, length = 60)
    private String mpwd; // 회원 비밀번호

    @Column(nullable = false, length = 30)
    private String mname; //회원 닉네임

    // + Entity --> Dto, 주로 조회할 때 사용
    public MemberDto toDto(){
        return MemberDto.builder()
                .mno(mno)
                .mid(mid)
                 // .mpwd(mpwd) 웬만하면 비밀번호를 밖으로 뺄 일이 없음. DTO 반환 안함!
                .mname(mname)
                .createDate( getCreateDate().toString() )
                .updateDate( getUpdateDate().toString() )
                .build();
    }
}
