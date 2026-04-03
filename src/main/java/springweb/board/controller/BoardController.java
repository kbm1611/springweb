package springweb.board.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springweb.board.dto.BoardDto;
import springweb.board.service.BoardSerivce;
import springweb.member.service.JWTService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
@CrossOrigin( value = "http://localhost:5173", exposedHeaders = "Authorization")
public class BoardController {

    private final BoardSerivce boardSerivce;
    private final JWTService jwtService;

    // [1-1] 회원제 글 등록 (세션)
    @PostMapping("/addpost")
    public ResponseEntity<?> addPost(@RequestBody BoardDto boardDto, HttpSession session){
        // 1) 세션 내 로그인정보 확인
        Object object = session.getAttribute("loginMid");
        if(object == null) return ResponseEntity.ok(false ); // 비로그인이면 글쓰기 실패
        String loginMid = (String)object;
        return ResponseEntity.ok( boardSerivce.addPost(boardDto, loginMid));
    }

    // [1-2] 회원제 글 등록 (토큰)
    @PostMapping("/addpost2")
    public ResponseEntity<?> addPost2(@RequestBody BoardDto boardDto, @RequestHeader("Authorization") String token){
        // 1) 매개변수로 jwt토큰 받는다.
        // 2) 문자열.startsWith("시작문자") : 문자열내 시작문자가 존재하면 true
        if( token == null || !token.startsWith("Bearer ")) return ResponseEntity.ok( false );
        // 3) 토큰에서 클레임(값) 꺼내기
        token = token.replace("Bearer ", "");
        String loginMid = jwtService.getclaim( token );
        if(loginMid == null) return ResponseEntity.ok( false );
        // 4) 서비스에게 입력받은 값과 토큰에 저장된 값 전달
        boolean result = boardSerivce.addPost(boardDto, loginMid);
        return ResponseEntity.ok( result );
    }

    // [1-3] 회우너제 글등록 + 토큰 정보 + 첨부파일
    @PostMapping("/addpost3")
    public ResponseEntity<?> addPost3(BoardDto boardDto, @RequestHeader("Authorization") String token){
        // 1] @RequestBody 사용하지 않는다. 왜? 첨부파일 매핑하기 위해
        // 2] dto에 MultipartFile 인터페이스 포함한다. private MultipartFile uploadFile; // 업로드용도
        if(token == null || !token.startsWith("Bearer")) return ResponseEntity.ok(false);
        token = token.replace("Bearer ", "");

        String loginMid = jwtService.getclaim(token);
        if(loginMid == null) return ResponseEntity.ok( false );
        boolean result = boardSerivce.addPost(boardDto, loginMid);
        return ResponseEntity.ok( result );
    }

    // [2-1] 내 글 확인(세션)
    @GetMapping("/mypost")
    public ResponseEntity<?> findAllMyPost(HttpSession session){
        Object object = session.getAttribute("loginMid");
        if(object == null) return ResponseEntity.ok( false );
        else return ResponseEntity.ok( boardSerivce.findAllMyPost((String)object) );
    }

    // [2-2] 내 글 확인(jwt)

}
