package example.day07.practice7.dto;

import example.day07.practice7.entity.CourseEntity;
import example.day07.practice7.entity.EnrollEntity;
import example.day07.practice7.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EnrollDto {
    private Integer enrollId;
    private String status;
    private Integer courseId;
    private String courseName;
    private Integer studentId;
    private String studentName;

    private String createAt;
    private String updateAt;

    public EnrollEntity toEntity(){
        return EnrollEntity.builder().enrollId(enrollId).status(status)
                .courseEntity( CourseEntity.builder().courseId(courseId).build() )
                .studentEntity( StudentEntity.builder().studentId(studentId).build() )
                .build();
    }
}
