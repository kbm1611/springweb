package 종합.예제10.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import 종합.예제10.board.dto.BoardDto;
import 종합.예제10.board.service.BoardService;

import java.util.List;

@RestController
public class BoardController {

    @Autowired
    private BoardService boardSvc;

    //등록
    @PostMapping("/board")
    public boolean bSvc(@RequestBody BoardDto boardDto){
        return boardSvc.bSvc(boardDto);
    }

    //전체 조회
    @GetMapping("/board")
    public List<BoardDto> bfindAll(){
        return boardSvc.bFindAll();
    }

    //개별 조회
    @GetMapping("/board/detail")
    public BoardDto bGet(@RequestParam Integer bno){
        return boardSvc.bGet(bno);
    }

    //삭제
    @DeleteMapping("/board")
    public boolean bDel(Integer bno){
        return boardSvc.bDel(bno);
    }

    //수정
    @PutMapping("/board")
    boolean bUpd(@RequestBody BoardDto boardDto){
        return boardSvc.bUpd(boardDto);
    }


}
