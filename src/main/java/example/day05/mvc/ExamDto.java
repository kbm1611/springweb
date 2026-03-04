package example.day05.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
@Data
public class ExamDto {
    private Integer eno;    //int 대신 Integer 사용
    private String ename;
    private String edate;
}
