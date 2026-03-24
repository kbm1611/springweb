package springweb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springweb.entity.MemberEntity;

@NoArgsConstructor@AllArgsConstructor@Data@Builder
public class MemberDto {
    private Long mno;
    private String mid;
    private String mpwd;
    private String mname;

    private String createDate;
    private String updateDate;

    // DTO --> ENTITY 저장/수정
    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .mid( mid )
                .mpwd(mpwd)
                .mname(mname)
                .build();
    }
}
