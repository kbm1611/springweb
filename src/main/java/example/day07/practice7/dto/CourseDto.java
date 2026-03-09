package example.day07.practice7.dto;

import example.day07.practice7.entity.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CourseDto {
    private Integer courseId;
    private String courseName;

    private String createAt;
    private String updateAt;

    public CourseEntity toEntity(){
        return CourseEntity.builder().courseId(courseId).courseName(courseName)
                .build();
    }
}
