package 종합.예제10.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import 종합.예제10.board.entity.BoardEntity;
import 종합.예제10.board.entity.CommentEntity;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
public class CommentDto {

    private Integer cno;
    private Integer bno;
    private String ccontent;
    private String cwriter;

    private String createDate;
    private String updateDate;

    public CommentEntity toEntity(){
        return CommentEntity.builder().cno(cno)
                .ccontent(ccontent)
                .cwriter(cwriter)
                // 중요: BoardEntity 객체를 새로 만들어 bno를 채운 뒤 빌더에 전달
                .boardEntity(BoardEntity.builder().bno(bno).build())
                .build();
    }
}
