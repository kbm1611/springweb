package example.day12.springschedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    //* 컨트롤러 유무와 상관없이 특정 시간이 되면 서비스 자동 실행*
    // 비동기 기반의 구조
    // AppStart 클래스 위에 @EnableScheduling 주입한다.

    // [1] 3초 마다 실행되는 스케줄 설정 // 서버를 킨 시간 기준
    @Scheduled( fixedRate = 3000) // 밀리초
    public void task1(){
        System.out.println("ScheduleService.task1");
    }

    // [2] 5초(변수값) 마다 실행되는 스케줄 설정 // 서버를 켠 시간 기준
    final int time = 5000;
    @Scheduled(fixedRate = time)
    public void task2(){
        System.out.println("ScheduleService.task2");
    }

    // [3] ** 시스템의 날짜/시간 기준으로 스케줄링
    // @Scheduled( cron = 초 분 시 일 월 요일 )
    @Scheduled(cron = "*/5 * * * * *") // 정확히 5초마다 11:11:05 , 11:11:10
    public void task3(){
        System.out.println("ScheduleService.task3");
    }
    @Scheduled(cron = "0 */1 * * * *") // 1분마다 11:11:00 , 11:12:00
    public void task4(){
        System.out.println("ScheduleService.task4");
    }


}
/*
    cron 패턴
        >> 형식 @Scheduled( cron = "초 분 시 일 월 요일" )
        1. 첫번째 초 : 0 ~ 59    2. 두번째 분 : 0 ~ 59
        3. 세번째 시 : 0 ~ 23    4. 네번째 일 : 1 ~ 31
        5. 다섯번째 월 : 1 ~ 12  6. 여섯번째 요일 : 0 ~ 6 ( 0이 일요일 )
    예시]
        1) 주말(일/토)마다 오전 10시 : @Scheduled( cron = " 0 0 10 * * 0,6 )
        2) 일요일마다 오전 9시       : @Scheduled( cron = " 0 0 9 * * 0 )
        3) 매월 1일 오전 8시30분    : @Scheduled( cron = " 0 30 8 1 * * )
    비동기 == 스케줄링 == 백그라운드
        1) HTTP와 상관없이 자바(서버)내 내부 로직 실행
        2) HTTP Response(응답) 제약 있다. 응답이 필요할 경우 추가 기술 필요
            HTTP( 무상태/비연결 ) vs Socket( 상태/연결유지 ) vs Message
                HTTP : CRUD , 기초 통신
                Socket : 실시간 양방향 통신 , 예] 채팅 / 실시간데이터 / 푸시알람(포스-키오스크)
*/
