package example.day07.practice7.entity;

import example.day07.practice7.dto.EnrollDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
@Entity @Table(name = "enroll")
public class EnrollEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer enrollId;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId")
    private CourseEntity courseEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private StudentEntity studentEntity;

    public EnrollDto toDto(){
        return EnrollDto.builder().enrollId(enrollId).status(status)
                .courseId(courseEntity.getCourseId())
                .studentId(studentEntity.getStudentId())
                .createAt(getCreateAt().toString())
                .updateAt(getUpdateAt().toString())
                .build();
    }
}
