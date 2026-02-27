package example.종합.예제9.controller;

import example.종합.예제9.model.dao.BoardDao;
import example.종합.예제9.model.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 빈등록 + HTTP 기능 + HTTP 응답객체
public class BoardController {
    @Autowired //의존성주입:등록된 빈(객체) 가져오기
    private BoardDao boardDao;

    //전체조회
    @GetMapping("/board")
    public List<BoardDto> findAll(){
        List<BoardDto> result = boardDao.findAll();
        return result;
    }

    //등록
    @PostMapping("/board")
    public boolean write(@RequestBody BoardDto boardDto){
        boolean result = boardDao.write( boardDto );
        return result;
    }

    //수정
    @PutMapping("/board")
    public boolean update(@RequestBody BoardDto boardDto){
        boolean result = boardDao.update( boardDto );
        return result;
    }

    //삭제
    @DeleteMapping("/board")
    public boolean delete(@RequestParam int bno){
        boolean result = boardDao.delete( bno );
        return result;
    }
}
