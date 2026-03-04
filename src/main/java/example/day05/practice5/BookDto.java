package example.day05.practice5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
@Data
public class BookDto {
    Integer bno;
    String bwriter;
    String btitle;
    String bpublisher;
}
