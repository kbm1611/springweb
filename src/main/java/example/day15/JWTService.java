package example.day15;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JWTService {

    // * 내가 만든 임의의 값으로 토큰에 사용되는 암호화 계산식의 비밀번호
    private final String secretPassword = "12345678912345678912345678912345";
    // * 내가 만든 임의의 값(비밀번호) 해시값(SHA)으로 변환
    private final Key secretKey = Keys.hmacShaKeyFor( secretPassword.getBytes() );

    // [1] JWT토큰 생성: 사용자의 정보를 JSON형식으로 암호화
    public String addToken(String data){
        String token = Jwts.builder() // 토큰 생성 시작
                // claim("key", value) 토큰에 저장할 자료를 key와 value 대입한다.
                .claim("data", data)
                // setExpiration(new Date(System.currentTimeMillis() + 1000* 초단위) )
                .setIssuedAt(new Date()) // 토큰 발급날짜/시간, new Date(): 시스템날짜/시간 반환 객체
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 15) ) // 토큰 유지/유효 시간
                // .signWith(비밀키, 암호화알고리즘)
                .signWith( secretKey, SignatureAlgorithm.HS256 ) // 최종 토큰 암호화는 HS256 알고리즘
                .compact(); // 토큰 최종 문자열로 반환
        return token;
    }

    // [2]
    public String extractToken(String token){
        try{
            Claims claims = Jwts.parser() // 파싱 / 가져온다는 뜻
                    .setSigningKey( secretKey ) // 서명 검증에 필요한 비밀키 대입
                    .build() // 비밀키 확인
                    .parseClaimsJws( token ) // 검증할 토큰 대입한다.
                    .getBody(); // 검증 성공시 클레임(내용물) 가져온다.
            return (String)claims.get( "data" ); // 저장된 값은 무조건 Object
        }catch (Exception e){
            return null;
        }
    }
}
/*
    JWT : json web token(징표)
        1. 정의: JSON형식의 데이터를 사용하기 위한 토큰 기반의 인증 형식
        2. 목적: 웹/앱에서 인증과 권한부여/확인 사용(클라이언트) VS 세션(서버) // 제일 안전한건 서버지만 과부하 때문에 사용

    사용법
        1) 설치
            implementation 'io.jsonwebtoken:jjwt-api:0.12.6'
            runtimeOnly 'io.jsonwebtoken:jjwt-impl:0.12.6'
            runtimeOnly 'io.jsonwebtoken:jjwt-jackson:0.12.6'
 */