package example.day02.practice2.problem;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/day02/practice2/problem")
public class BoardController {

    @PostMapping("/board")
    public boolean boardWrite( @RequestBody BoardDto boardDto){
        return true;
    }

    @GetMapping("/board")
    public ArrayList<BoardDto> boardPrint(){
        ArrayList<BoardDto> boardDtos = new ArrayList<>();
        BoardDto boardDto1 = new BoardDto(1, "안녕하세요", "유재석");
        BoardDto boardDto2 = new BoardDto(2, "안녕하세요2", "강호동");
        boardDtos.add(boardDto1);
        boardDtos.add(boardDto2);
        return boardDtos;
    }

    @GetMapping("/board/detail")
    public BoardDto boardDetail(@RequestParam int bno){
        BoardDto boardDto = new BoardDto(1, "안녕하세요", "유재석");
        return boardDto;
    }

    @DeleteMapping("/board")
    public boolean boardDelete(@RequestParam int bno){
        return true;
    }

    @PutMapping("/board")
    public boolean boardUpdate(@RequestBody BoardDto boardDto){
        return true;
    }
}
