package springweb.member.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springweb.member.dto.MemberDto;
import springweb.member.service.JWTService;
import springweb.member.service.MemberService;

import java.net.http.HttpResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member3")
@CrossOrigin( value = "http://localhost:5173", allowCredentials = "true")
public class MemberController3 {
    private final MemberService memberService;
    private final JWTService jwtService;

    // [1] 회원가입

    // [2] 로그인 = 세션방식 ---> 토큰방식 변경 + 쿠키
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberDto loginDto, HttpServletResponse response){
        boolean result = memberService.login( loginDto );
        // 1] 만약에 로그인 성공이면 토큰 부여
        if( result ){
            String token = jwtService.createToken( loginDto.getMid() ); // 2] 로그인 성공한 정보(아이디) 토큰에 저장
            // =============== 쿠키에 토큰 담아서 응답하기 =================
            // (1) 쿠키에 토큰 담기 , new Cookie( "속성명" , 값 );
            Cookie cookie = new Cookie( "token", token );
            // (2) 쿠키 옵션 *
            cookie.setHttpOnly(true); // .setHttpOnly( true ): 쿠키접근 방법, true이면 js가 접근을 못한다.
            cookie.setSecure(false); // .setSecure( true ): true이면 https만 접근 가능
            cookie.setPath("/"); // .setPath(): 쿠키 접근하는 경로 , "/": 전체경로
            // cookie.setMaxAge(); // .setMaxAge( 초 ) : 쿠키 유지시간
            // (3) 쿠키 응답하기 , response.addCookie( 쿠키객체 );
            response.addCookie( cookie );
            return ResponseEntity.ok( true );
        }else{ return ResponseEntity.ok( false ); }
    }

    // [3] 로그아웃

    // [4] 마이페이지
}
/*

    HTTP: 문자 이동 규약/규칙

    톰캣 세션 VS 쿠키
                : 서버 , 보안높음     , 로그인
        VS

    쿠키
                : 브라우저 , 보안낮음(JWT)  , 로그인+/장바구니/자동로그인/사용자설정(테마)
        * TOKEN : 특정한 자료 암호화(JWT)해서 인증

    활용) 1) 세션은 서버에 저장하므로 *보안* 높지만 *대규모*서버에는 과부하 증가한다.
         2) 토큰은 세션/쿠키 없이 HTTP 사용하지 않으므로 웹/앱 통합 가능하다.
         3) 쿠키는 브라우저에 저장하므로 *보안* 낮지만 JWT와 같이 사용하며 서버에 과부하 낮을 수 있다.
         즉] 앱(JWT), 웹(JWT/cookie)
 */
