package springweb.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller // RestController 사용하지 않은 이유: HTTP 응답이 아니라서
public class ChatController {

    // DTO : 속성들을 미리구성한 구조, MAP: 속성들을 직접 구조
    @MessageMapping("/chat")
    @SendTo("/topic/message") // 클라이언트 <--- 서버에게 메시지를 보낸 주소 매핑, 클라이언트 ---> 서버
    public Map<String, Object> sendMessage( Map<String, Object> message){
        System.out.println("message = " + message);
        System.out.println("ChatController.sendMessage");

        return message;
    }
}
