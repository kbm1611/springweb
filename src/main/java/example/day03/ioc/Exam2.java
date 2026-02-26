package example.day03.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// === 방법1: 다른 클래스의 메소드를 호출하는 방법1 ===
class TaskDao1{ void method1(){} }
class TaskController1{
    void method(){
        TaskDao1 taskDao1 = new TaskDao1(); // 객체 생성
        taskDao1.method1(); // 해당 객체 내 메소드 호출
    }
}
// === 방법2 : 다른 클래스의 메소드를 호출하는 방법2 ===
class TaskDao2{ static void method2(){} }
class TaskController2{
    void method(){
        TaskDao2.method2(); // static 메소드는 객체 없이 클래스명.메소드명
    }
}
// === 방법3 : 다른 클래스의 메소드를 호출하는 방법 3 ===
class TaskDao3{
    private TaskDao3(){}
    private static TaskDao3 instance = new TaskDao3();
    public static TaskDao3 getInstance(){ return instance; }
    void method3(){}
}
class TaskController3{
    void method(){
        TaskDao3.getInstance().method3();
    }
}
// === 방법4 : 다른 클래스의 메소드를 호출하는 방법 4 ===
@Component // IOC 스프링 컨테이너 빈 등록
class TaskDao4{ void method4(){} }
class TaskController4{
    // DI 방법1 // 해당하는 변수에 스프링 빈에 등록된 객체를 주입 해준다.
    // @Autowried private TaskDao4 taskDao4;

    // DI 방법2 // *권장*
    private final TaskDao4 taskDao4; // final은 수정 불가능한 키워드, 초기화 필수
    @Autowired
    public TaskController4( TaskDao4 taskDao4 ){
        this.taskDao4 = taskDao4;
    }

    void method(){
        taskDao4.method4();
    }
}

public class Exam2 {
    /*
        IOC: 제어의 역전, 개발자가 직접 해야하는 객체 제어권을 스프링에게 위임
            1. 정의: 객체의 생성과 관리의 *제어권*을 개발자가 아닌 스프링에게 위임한다.
            2. 스프링에서 스프링*컨테이너* 담당한다.
            3. 목적: 개발자에게 편의성, 규칙성(협업간의 객체 충돌 방지)
            4. 주요 어노테이션
                @Component: 스프링 컨테이너에 클래스(Bean빈)의 정보를 등록한다.
                Spring MVC 내장: @Controller, @RestController, @Service @Repository @Configuration 등등
                * 즉] MVC 패턴은 IOC 기반이면서 필수


        DI: 의존성 주입, IOC 표현하기위한 기술 중 하나, 위임한 객체 제어권에서 객체 가져오기
     */
}
