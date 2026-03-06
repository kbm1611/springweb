package 종합.예제10.board.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import 종합.예제10.board.dto.CommentDto;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
@Entity @Table(name = "comment")
public class CommentEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cno;

    @ManyToOne
    @JoinColumn(name = "bno", foreignKey = @ForeignKey(name = "FK_BOARD_COMMENT"))
    private BoardEntity boardEntity;

    @Column(columnDefinition = "longtext not null")
    private String ccontent;

    @Column(nullable = false)
    private String cwriter;

    public CommentDto toDto(){
        return CommentDto.builder().cno(cno).bno( boardEntity.getBno() )
                .cwriter(cwriter).ccontent(ccontent)
                .createDate(getCreateDate().toString()).updateDate(getUpdateDate().toString())
                .build();
    }
}
