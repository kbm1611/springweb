package example.day05.practice5;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data @AllArgsConstructor @NoArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY ) // auto_increment 적용하겠다는 뜻
    private Integer bno;

    @Column( name = "bwriter", length = 255 , nullable = false) // 테이블 필드 속성
    private String bwriter;

    @Column( name = "btitle", length = 255 , nullable = false) // 테이블 필드 속성
    private String btitle;

    @Column( name = "bpublisher", length = 255 , nullable = false) // 테이블 필드 속성
    private String bpublisher;
}
