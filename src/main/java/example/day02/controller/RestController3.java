package example.day02.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// @Component
// @Controller // +HTTP 통신 기능 포함 -> 사용처 : view 반한
@RestController // + ResponseBody 포함 -> 사용처 : 값 반환(JSON)
@RequestMapping("/day02")//@RequestMapping("/공통URL") 해당 컨트롤러내 메소드들이 사용하는 공통URL 정의
public class RestController3 {
    //1. 클래스가 @RestController이므로 @ResponseBoby 생략해도 된다.
    @GetMapping("/task6")
    public String method1(){ return "서버에게 받은 메시지"; }

    //2. http://localhost:8080/day02/task7?name=유재석&age=40
    @GetMapping("/task7") // 쿼리스트링이란? URL(웹주소) 뒤로 ? 작성후 매개변수명1=값&매개변수2=값
    public int method2(@RequestParam String name, @RequestParam int age ){
        // @RequestParam 이란? URL(웹주소)안에 포함된 쿼리스트링 매개변수 값 가져오는 어노테이션 / 생략가능
        System.out.println("RestController3.method2"); // soutm : 메소드명 출력 자동완성
        System.out.println("name = " + name + ", age = " + age); // soutp: 메소드 매개변수 출력 자동완성
        return 7;
    }
    //3. http://localhost:8080/day02/task8?age=40
    @GetMapping("/task8")
    public int method3(@RequestParam( required = false ) String name, @RequestParam(name = "age") int 나이){
        // 만약에 쿼리스트링의 매개변수명과 자바의 매개변수명이 다르면 @RequestParam( name = "쿼리스트링매개변수명")
        // 만약에 쿼리스트링의 매개변수명을 필수로 하지 않을경우 @RequestParam( required = false ), 기본값은 true
        System.out.println("RestController3.method3");
        System.out.println("name = " + name + ", 나이 = " + 나이);
        return 8;
    }
    // 4.http://localhost:8080/day02/task9?name=유재석
    @DeleteMapping("/task9") //
    public int method4(String name, @RequestParam( defaultValue = "19") int age){
        // 만약에 @RequestParam 생략해도 매개변수 매핑(연결) 가능하다.
        // 만약에 쿼리스트링에 매개변수명이 존재하지 않을때 기본값으로 설정하기, @RequestParam(defaultValue = "값")
        System.out.println("RestController3.method4");
        System.out.println("name = " + name + ", age = " + age);
        return 9;
    }
    // 5.http://localhost:8080/day02/task10?name=유재석&age=40
    @DeleteMapping("/task10")
    public int method5( @RequestParam Map<String, Object> map){
        System.out.println("RestController3.method5");
        System.out.println("map = " + map);
        return 10;
    }
    // 6.http://localhost:8080/day02/task11?name=유재석&age=40
    @PostMapping("/task11")
    public int method6(@ModelAttribute ExamDto examDto){
        System.out.println("RestController3.method6");
        System.out.println("examDto = " + examDto);
        return 11;
    }
    // 즉] URL?매개변수명=값 방식인 쿼리스트링은 URL상 매개변수 노출이 된다.
    // GET/DELETE -> 쿼리스트링 -> @RequestParam/@ModelAttribute
    // POST/PUT -> +BODY본문 -> @RequestBody
    // 즉] URL 상의 매개변수 노출이 가리기 위한 BODY(본문) 사용하자.
    // 회원가입/로그인
    //      개인정보/패스워드/민감한 정보들은 POST/PUT BODY(본문) 사용하자.
    // 예시] 편지의 편지봉투 = 쿼리스트링, 편지의 내용물(편지지) = BODY

    // 7. http://localhost:8080/day02/task12
    // Body : { "name" : "유재석" , "age" : 40 }
    // HTML --> JS --> JAVA( controller -> dao )
    @PostMapping("/task12")
    public int method12(@RequestBody ExamDto examDto){
        System.out.println("RestController3.method12");
        System.out.println("examDto = " + examDto);
        return 12;
    }
    // 8.
    @PutMapping("/task13")
    public int method13(@RequestBody ExamDto examDto){
        System.out.println("RestController3.method13");
        System.out.println("examDto = " + examDto);
        return 13;
    }


}
