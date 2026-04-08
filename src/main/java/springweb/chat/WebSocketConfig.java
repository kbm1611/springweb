package springweb.chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration // 빈(객체)
@EnableWebSocketMessageBroker // [2] websocket + stomp 메시지 브로커 활성화
public class WebSocketConfig  implements WebSocketMessageBrokerConfigurer {
    // 스프링프레임워크 장점: 인터페이스 구조라서 만들어진 기능들을 재정의(커스텀)가 가능하다,
    // 오버라이딩(재정의) vs 오버로딩(매개변수에 따라 메소드/생성자 정의)
    // super(상위객체) vs this(현재객체)

    // [3] 메시지 브로커 설정
    @Override // 오버라이딩
    public void configureMessageBroker(MessageBrokerRegistry registry){

        // [4] 구독 주소 설정 : 클라이언트가 설정한 주소를 요청(구독)하면 (서버에게) 메시지를 받을 수 있다.
        // http://localhost:8080/topic/ ~~~
        registry.enableSimpleBroker( "/topic" );

        // [5] 발행 주소 설정 : 클라이언트가 서버에게 메시지를 보낼 때 사용되는 주소 앞에 붙는 키워드
        // http://localhost:8080/app/ ~~~
        registry.setApplicationDestinationPrefixes( "/app");
    }
    // [6] websocket 접속 주소 설정 : 엔드포인트( 메시지의 종착점 )
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // [7]
        registry.addEndpoint( "/ws" ) //엔드포인트 : ws//localhost:8080/ws
            // .setAllowedOrigins("http://localhost:5173") // 특정 도메인 허용
                .setAllowedOrigins("*"); // 요청 가능한 도메인들, *: 모든도메인허용, CORS
    }
}
/*
    HTTP  클라이언트가 서버에게 *요청하면* 서버에게 응답받는 구조
        -> 단방향 구조, 무상태(상태/값 유지 안함), Request/Response
        -> RESTAPI CRUD
    VS
    WebSocket(프로토콜): 클라이언트와 서버가 연결 상태 유지하고, 서로 통신하는 구조
    -> 양방향 구조, 상태유지, STOMP( pub(발행) / sub(구독) )
    -> 실시간 통신( 채팅, 알림, 지도/실시간위치 )
 */
