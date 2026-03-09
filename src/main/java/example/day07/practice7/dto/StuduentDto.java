package example.day07.practice7.dto;

import example.day07.practice7.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StuduentDto {
    private Integer studentId;
    private String studentName;

    private String createAt;
    private String updateAt;

    public StudentEntity toEntity(){
        return StudentEntity.builder().studentId(studentId).studentName(studentName)
                .build();
    }
}
