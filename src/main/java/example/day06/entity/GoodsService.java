package example.day06.entity;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepo;

    public boolean save(GoodsDto goodsDto){
        // 1] dto -> entity 변환
        GoodsEntity goodsEntity = goodsDto.toEntity();

        // 2] JPA save 이용하여 엔티티 insert하기 +
        // 3] save 결과에 pk 여부 성공판단
        return goodsRepo.save( goodsEntity ).getGno() > 0;
    }

    public boolean update(GoodsDto goodsDto){
        // 1] 수정할 엔티티의 pk번호 확인
        // 2] 수정할 엔티티 찾기 --> 영속성
        Optional<GoodsEntity> optional = goodsRepo.findById( goodsDto.getGno() );
        // 3] 만약에 찾은 엔티티가 존재하면
        if( optional.isPresent() ){
            GoodsEntity updateEntity = optional.get();
            updateEntity.setGname( goodsDto.getGname() );
            updateEntity.setGprice( goodsDto.getGprice() );
            updateEntity.setGdesc( goodsDto.getGdesc() );
            return true;
        }else{
            return false;
        }

    }

}
