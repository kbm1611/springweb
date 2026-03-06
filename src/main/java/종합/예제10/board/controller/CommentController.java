package 종합.예제10.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import 종합.예제10.board.dto.CommentDto;
import 종합.예제10.board.service.CommentService;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentSvc;

    @GetMapping("/comment")
    public List<CommentDto> cmtPrt(@RequestParam Integer bno){
        return commentSvc.cmtPrt(bno);
    }
    @PostMapping("/comment")
    public boolean cmtSvc(@RequestBody CommentDto commentDto){
        return commentSvc.cmtSvc(commentDto);
    }
    @DeleteMapping("/comment")
    public boolean cmtDel(@RequestParam Integer cno){
        return commentSvc.cmtDel(cno);
    }
    @PutMapping("/comment")
    public boolean cmtUpd(@RequestBody CommentDto commentDto){
        return commentSvc.cmtUpd(commentDto);
    }

}
