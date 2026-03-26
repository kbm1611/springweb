package springweb.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import springweb.board.entity.BoardEntity;

@NoArgsConstructor @AllArgsConstructor @Data @Builder
public class BoardDto {
    private Long bno;
    private String btitle;
    private String bcontent;
    private String bfile;
    // + Dto에는 엔티티 정보를 포함하지 않는다.
    private Long mno;
    private String mname;
    // + BaseTime 멤버변수
    private String createDate;
    private String updateDate;
    // + 첨부파일 매핑, 여러개이면 리스트로 처리 List<MultipartFile>
    private MultipartFile uploadFile;

    public BoardEntity toEntity(){
        return BoardEntity.builder()
                .btitle(btitle)
                .bcontent(bcontent)
                .bfile(bfile)
                // .memberEntity() fk는 서비스에서 대입
                .build();
    }
}
