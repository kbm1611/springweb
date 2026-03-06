package 종합.예제10.board.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import 종합.예제10.board.entity.BoardEntity;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
public class BoardDto {
    private Integer bno;
    private String btitle;
    private String bcontent;
    private String bwriter;

    private String createDate;
    private String updateDate;

    public BoardEntity toEntity(){
        return BoardEntity.builder().bno(bno).btitle(btitle).bcontent(bcontent).bwriter(bwriter)
                .build();
    }

}
