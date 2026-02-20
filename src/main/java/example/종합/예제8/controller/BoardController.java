package example.종합.예제8.controller;

import example.종합.예제8.model.dao.BoardDao;
import example.종합.예제8.model.dto.BoardDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController // 해당 컨트롤러는 HTTP 기능을 갖게 된다. < 싱글톤 유사 포함 >
// Post, Get, Delete, Put -> 4가지를 합쳐서 레스트라고 부름.
public class BoardController {

    private BoardDao bd = BoardDao.getInstance();

    // [1] 게시물 등록 controller
    @PostMapping //등록은 PostMapping
    public boolean write( String bcontent, String bwriter ){
        boolean result = bd.write( bcontent, bwriter );
        return  result;
    }
    // [2] 게시물 전체 조회 controller
    @GetMapping // 해당 메소드의 HTTP웹 통신 기능 갖게 된다.
    public ArrayList<BoardDto> findAll(){
        ArrayList<BoardDto> result = bd.findAll();
        return result;
    }
    // [4] 게시물 삭제 controller
    @DeleteMapping //삭제에는 DeleteMapping
    public boolean delete( int bno ){
        boolean result = bd.delete( bno );
        return result;
    }
    // [3] 게시물 수정 controller
    @PutMapping //수정에는 PutMapping
    public boolean update( int bno, String bcontent ){
        boolean result = bd.update( bno, bcontent );
        return result;
    }
}
