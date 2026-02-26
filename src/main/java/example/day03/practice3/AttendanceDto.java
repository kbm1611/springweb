package example.day03.practice3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor@AllArgsConstructor
public class AttendanceDto {
    int ano;
    String studentName;
    String date;
    String status;
}
