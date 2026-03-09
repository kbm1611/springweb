package example.day07.relationship;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
@Entity @Table(name = "board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bno;
    private String bcontent;
    // ** 단방향 ** FK 만들기 **
    // @JoinColumn 관례적으로 fk 필드명도 pk필드명과 동일
    // @ManyToOne 다수가 하나에게 , M:1 , 여러개 게시물이 하나의 카테고리에 붙음
    @ManyToOne
    @JoinColumn(name = "cno") //관례적으로 fk 필드명도 pk필드명과 동일
    private CategoryEntity categoryEntity;

    @OneToMany( mappedBy = "boardEntity")
    @ToString.Exclude
    @Builder.Default
    private List<ReplyEntity> replyEntityList = new ArrayList<>();

}
/*
    create table board (
        bno integer not null auto_increment,
        cno integer,
        bcontent varchar(255),
        primary key (bno)
    ) engine=InnoDB
 */
