package springweb.board.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springweb.board.dto.BoardDto;
import springweb.board.service.BoardSerivce;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

    private final BoardSerivce boardSerivce;

    // 회원제 글 등록
    @PostMapping("/addpost")
    public ResponseEntity<?> addPost(@RequestBody BoardDto boardDto, HttpSession session){
        // 1) 세션 내 로그인정보 확인
        Object object = session.getAttribute("loginMid");
        if(object == null) return ResponseEntity.ok(false ); // 비로그인이면 글쓰기 실패
        String loginMid = (String)object;
        return ResponseEntity.ok( boardSerivce.addPost(boardDto, loginMid));
    }

    @GetMapping("/mypost")
    public ResponseEntity<?> findAllMyPost(HttpSession session){
        Object object = session.getAttribute("loginMid");
        if(object == null) return ResponseEntity.ok( false );
        else return ResponseEntity.ok( boardSerivce.findAllMyPost((String)object) );
    }

}
