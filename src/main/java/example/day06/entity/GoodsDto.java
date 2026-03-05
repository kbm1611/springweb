package example.day06.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
public class GoodsDto {
    private Integer gno;
    private String gname;
    private Integer gprice;
    private String gdesc;

    private String createDate;
    private String updateDate;

    // ** DTO --> ENTITY 반환 함수
    public GoodsEntity toEntity(){
        return GoodsEntity.builder().gno(this.gno).gname(this.gname).gprice(this.gprice).gdesc(this.gdesc).build();
    }
}
