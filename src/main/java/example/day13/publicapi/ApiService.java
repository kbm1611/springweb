package example.day13.publicapi;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ApiService {

    // * 공공데이터 개인API인증키 ( 로그인 -> 마이페이지 )
    String serviceKey = "eyKPby0UPPFqL5Exwp%2Br0WzpesAXgkXVBxpGaeEC4LDFkv5WLKFeRXIyHvGM2ZTyN1noFW4T998FMevfB%2BofBg%3D%3D";

    // * web 요청 객체 만들기, WebClient 이용한 외부 HTTP 요청/응답
    private final WebClient webClient = WebClient.builder().build();

    // [1] 인천광역시 부평구_맛있는 집(맛집) 현황 JSON
    // https://api.odcloud.kr/api/15103411/v1/uddi:b7c1c017-1d8d-4b19-8bec-c91a13927ea2?page=1&perPage=10&serviceKey=eyKPby0UPPFqL5Exwp%2Br0WzpesAXgkXVBxpGaeEC4LDFkv5WLKFeRXIyHvGM2ZTyN1noFW4T998FMevfB%2BofBg%3D%3D
    public Map<String, Object> test1(){
        String uri = "https://api.odcloud.kr/api/15103411/v1/uddi:b7c1c017-1d8d-4b19-8bec-c91a13927ea2?page=1&perPage=10&serviceKey=eyKPby0UPPFqL5Exwp%2Br0WzpesAXgkXVBxpGaeEC4LDFkv5WLKFeRXIyHvGM2ZTyN1noFW4T998FMevfB%2BofBg%3D%3D";
        return webClient.get() // 요청할 api 주소 넣어준다. url vs uri(매개변수 포함)
                .uri( uri )
                .retrieve() // 반환/통신/응답 결과 수신
                .bodyToMono( Map.class ) // 반환값 자바 타입으로 변환
                .block(); // 동기( 처리가 끝날 때 까지 대기상태) 방식으로 결과 반환
    }

    // [2] 전국 약국 정보 조회 서비스 XML
    // https://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyFullDown?serviceKey=eyKPby0UPPFqL5Exwp%2Br0WzpesAXgkXVBxpGaeEC4LDFkv5WLKFeRXIyHvGM2ZTyN1noFW4T998FMevfB%2BofBg%3D%3D&pageNo=1&numOfRows=10
    public String test2(){
        String uri = "https://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyFullDown?serviceKey=eyKPby0UPPFqL5Exwp%2Br0WzpesAXgkXVBxpGaeEC4LDFkv5WLKFeRXIyHvGM2ZTyN1noFW4T998FMevfB%2BofBg%3D%3D&pageNo=1&numOfRows=10";
        String result = webClient.get()
                .uri( uri ) // 통신 할 주소
//                .header("Authorization", "Infuser " + serviceKey)
                // HTTP 헤더란? HTTP ㅌㅇ신할 때 부가정보 포함하는 정보
                    // 주로 인증 관련된 정보들을 포함하는 경우가 있다. API키, 로그인상태
                .retrieve() // 통신 결과/응답 수신/받기
                .bodyToMono( String.class ) // 반환 타입 , XML --> String 타입으로 받아오기
                .block(); // 동기통신
        return result;
        // *************** String( XML ) --- 변환 --> MAP/DTO 변환, JACKSON ***************
//        try {
//            XmlMapper xmlMapper = new XmlMapper(); // xml 매퍼 객체 생성한다.
//            // xmlMapper.readValue( 변환할값 , 변환할타입.class );
//            Map<String, Object> map =  xmlMapper.readValue( result, Map.class ); // String(XML) --> MAP 타입변환
//            return map;
//        }catch (Exception e){  System.out.println( e ); }
//        return null;
    }


}
/*
    API : 데이터 주고받고 기능을 공유할 수 있는 규칙/프로토콜(HTTP)
    REST API : HTTP기반의 API
    종류
        1. 개발 : SPRING CONTROLLER
        2. 활용 : 무료/유료 판단
            1)공공데이터포털 API
            2) LLM(AI모델) API
            3) 사기업
                카카오(지도,로그인),
                네이버(로그인,데이터랩 등),
                구글(로그인, 자동입력방지/캡챠),
                번역( DeepL, 파파고 등)
                결제( 테스트: 아임포트 / 카카오페이 )
                등등
    반환타입 : JSON(변환 x) / XML(변환 o)
    스프링에서 외부HTTP 요청 , 프로젝트1/서비스1 <--통신--> 프로젝트2/서비스2
    https://start.spring.io/
    Spring Reactive Web Web
    im
        - controller : 서버입장의 통신 받는 곳
        - webflux : 서버입장에서 먼저 통신 요청
    XML이란? < > 괄호 사용한 마크업언어
        - 스프링(자바)에서 타입변환이 필요하다.

 */
