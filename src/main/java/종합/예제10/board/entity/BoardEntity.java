package 종합.예제10.board.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import 종합.예제10.board.dto.BoardDto;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity @Table(name = "board")
public class BoardEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bno;

    @Column( nullable = false )
    private String btitle;

    @Column( columnDefinition = "longtext not null") // longtext 가 자바에는 없기에 직접 넣어줘야 함.
    private String bcontent;

    @Column(length = 30 , nullable = false)
    private String bwriter;

    public BoardDto toDto(){
        return BoardDto.builder().bno(bno).btitle(btitle).bcontent(bcontent).bwriter(bwriter)
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .build();
    }

}
