package example.day04.ch3;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor( access = AccessLevel.PROTECTED) // 빈생성자이면서 protected 접근제한 (자동 생성)
@AllArgsConstructor // 전체 매개변수를 갖는 (자동생성) 새엇ㅇ자
@Getter
@Entity // 데이터베이스의 테이블의 레코드와 매핑(연결) 기술: ORM(자바객체<--> DB레코드)
public class Member {
    @Id // Primary Key
    @GeneratedValue( strategy = GenerationType.IDENTITY ) // auto.increment
    @Column( name = "id" , updatable = false) // 필드/속성 설정. 수정 불가능
    private Long id;

    @Column(name = "name", nullable = false) //필드/속성 설정, not null
    private  String name;
}
