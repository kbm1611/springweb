package example.day06.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data @Builder //롬복
// + 영속성
@Entity @Table(name = "goods") // 새량시 클래스명으로 자동설정
public class GoodsEntity extends BaseTime {

    @Id // JPA는 엔티티내 1개 이상의 primary key가 필수
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gno; // 제품번호

    @Column(name = "gname", nullable = false, length = 100, unique = true, insertable = true, updatable = true)
    private String gname; // 제품명

    // @Column // 생략가능시 : 자바의 타입 --> SQL 타입, 자바의 변수명 --> SQL 필드명
    private Integer gprice; // 제품가격

    @Column( columnDefinition = "vachar(100) default '제품설명' not null") // 수동
    private String gdesc; // 제품설명
}
/*
    @Id : primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) : auto_increment
    @Column( )
        name : "필드명"
        nullable = false : not null
        length = 길이 , 기본값은 255, 길이
        unique = true , 기본값은 false 중복 불가능
        insertable = true , 기본값 true , insert 할 때 적용 여부
        updatable = true , 기본값 true , update 할 때 적용 여부
        columDefinition = "SQL"
    레코드 생성날짜/수정날짜 자동 지원
 */