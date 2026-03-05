package example.day06.entity;

import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass // 1] 엔티티 상속용도 클래스 -> 엔티티 확장 가능, 자바에서 쓸꺼면 안 써도 됨.
public class BaseTime {

    private LocalDateTime createDate;

    private LocalDateTime updateDate;
}
