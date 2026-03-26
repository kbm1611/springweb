package springweb.member.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service @RequiredArgsConstructor
public class JWTService {

    // [*] 비밀키 정의
    private final String secret = "123456789123456789123456789123456789"; // 개발자가 임의로 32글자 이상
    private final Key secretKey = Keys.hmacShaKeyFor( secret.getBytes( StandardCharsets.UTF_8 ) );
    // [1] 토큰 발급
    public String createToken(String mid){
        String token = Jwts.builder()
                .claim("mid", mid) // 키,값 형태로 넣음
                .setIssuedAt(new Date()) // 토큰 발급날짜/시간
                .setExpiration( new Date(System.currentTimeMillis() * 1000 * 20 ) ) // 토큰 유지/유효 시간
                .signWith(secretKey, SignatureAlgorithm.HS256 ) // 토큰에 비밀키 넣고 서명 아록리즘( HS256 )
                .compact();
        return token;
    }
    // [2] 토큰의 클레임(내용물) 추출
    public String getclaim( String token ){
        try{
            Claims claims = Jwts.parser()
                    .setSigningKey( secretKey ) // 비밀키 대입
                    .build() // 비밀키가 일치하지 않으면 예외 발생
                    .parseClaimsJws( token ) // 서명확인할 토큰 대입
                    .getBody(); // 서명확인 토큰 내 클레임(내용물) 반환 / 없으면 예외 발생
            return (String)claims.get("mid");
        }catch (Exception e){
            System.out.println(" Runtime 예외 발생");
            return null; // 토큰이 없거나 유효하지 않을 때
        }
    }

}
