package example.day07.practice7.entity;

import example.day07.practice7.dto.StuduentDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "student")
public class StudentEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer studentId;
    private String studentName;

    @OneToMany( mappedBy = "studentEntity")
    @ToString.Exclude
    @Builder.Default
    private List<EnrollEntity> enrollEntityList = new ArrayList<>();

    public StuduentDto toDto(){
        return StuduentDto.builder().studentId(studentId).studentName(studentName)
                .createAt(getCreateAt().toString())
                .updateAt(getUpdateAt().toString())
                .build();
    }
}
