package example.day03.practice3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor@AllArgsConstructor
public class AttendanceDto {
    private Integer ano;
    private String studentName;
    private String date;
    private String status;
}
