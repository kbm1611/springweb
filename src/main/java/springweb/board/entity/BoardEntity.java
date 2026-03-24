package springweb.board.entity;

import example.day06.entity.BaseTime;
import jakarta.persistence.*;
import lombok.*;
import springweb.board.dto.BoardDto;
import springweb.member.entity.MemberEntity;

@Entity @Table(name = "board")
@NoArgsConstructor@AllArgsConstructor@Data@Builder
public class BoardEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno; // 게시물 번호

    @Column( nullable = false, length = 255 )
    private String btitle; // 게시물 제목

    @Column( nullable = false, columnDefinition = "longtext" )
    private String bcontent; // 게시물 내용

    @Column(length = 255) // 주로 첨부파일은 파일자체를 저장하는게 아니라. 파일의 위치(서버 내 경로) 저장
    private String bfile; // 게시물 첨부 파일, 만약에 게시물 당 첨부파일 여러개이면 엔티티 분리

    // + 단방향: 한 명의 회원이 여러 개 게시물 작성한다. 1:N
    @ManyToOne
    @JoinColumn(name = "mno") @ToString.Exclude
    private MemberEntity memberEntity;

    public BoardDto toDto(){
        return BoardDto.builder().
                bno(bno).btitle(btitle).
                bcontent(bcontent).bfile(bfile).
                mno(memberEntity.getMno()).mname(memberEntity.getMname()).
                createDate(getCreateDate().toString()).
                updateDate(getUpdateDate().toString()).
                build();
    }
}
