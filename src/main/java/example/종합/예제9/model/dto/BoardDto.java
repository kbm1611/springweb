package example.종합.예제9.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor //매개변수없는 기본 생성자, 전체매개변수 생성자
@Data // getter, setter, toString, RequiredArgsConstructor( final 멤버변수 생성자 )
public class BoardDto {
    private Integer bno; // int -> Integer null값 대응하기 위한 래퍼클래스
    private String bcontent;
    private String bwriter;
    private String bdate;
}
