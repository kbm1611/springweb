package example.day06.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsSvc;

    // 저장
    @PostMapping("/goods")
    public boolean save(@RequestBody GoodsDto goodsDto){
        return goodsSvc.save(goodsDto);
    }

    //수정
    @PutMapping("/goods")
    public boolean update(@RequestBody GoodsDto goodsDto){
        return goodsSvc.update(goodsDto);
    }
}
