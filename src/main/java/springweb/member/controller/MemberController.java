package springweb.member.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springweb.member.dto.MemberDto;
import springweb.member.service.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    // [1] 회원가입 post = create = save
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody MemberDto memberDto){
        return ResponseEntity.ok( memberService.signup(memberDto) );
    }

    // [2] 로그인 post == select == find
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberDto loginDto, HttpSession session){

        // 1] 입력받은 아이디/비밀번호를 서비스에게 보낸다.
        boolean result = memberService.login(loginDto);
        // 2] 만약에 로그인 성공이면 세션 부여
            // 1) 매개변수에 HttpSession session 받는다.
            // 2) .setAttribute( "속성명", 송성값);
        if(result) session.setAttribute("loginMid", loginDto.getMid() );

        // 3] 아니면 실패
        return ResponseEntity.ok( result );
    }

    // [3] 로그아웃 == GET == 세션 초기화
    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session){
        // 1) 매개변수에 HttpSession session 받는다.
        // 2) session.removeAttribute("삭제 할 속성명" );
        session.removeAttribute("loginMid");
        // 3) session.invalidate(); // 다 삭제
        return ResponseEntity.ok( true );
    }

    // [4] 마이페이지 == GET == 현재로그인된 회원 정보 == 세션 저장 된 정보로 조회
    @GetMapping("/myinfo")
    public ResponseEntity<?> myInfo(HttpSession session){
        // 1) 로그인상태 꺼내기 *모든 세션객체 내 속성값은 Object 타입이다. *
        Object obj = session.getAttribute("loginMid");
        // 2) 로그인상태가 존재하지 않으면 비로그인상태
        if( obj == null) return ResponseEntity.ok( false );
        // 3) 로그인 상태이면, Object --> String
        String loginMid = (String)obj;
        // 4) 로그인된 mid로 서비스에게 전달하여 로그인된 mid의 dto 받아오기
        return ResponseEntity.ok( memberService.myInfo(loginMid) );
    }
}
