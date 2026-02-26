package example.day03.practice3;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/day03/practice3/attendance")
public class AttendaceController {
    //출석 등록
    @PostMapping
    public boolean attendancePost(@RequestBody AttendanceDto attendanceDto){
        System.out.println("attendanceDto = " + attendanceDto);
        System.out.println("AttendaceController.attendancePost");
        return true;
    }
    //출석 전체조회
    @GetMapping
    public List<AttendanceDto> attendanceGETALL(){
        System.out.println("AttendaceController.attendancePrint");
        List<AttendanceDto> attendanceDtoList = new ArrayList<>();
        AttendanceDto attendanceDto = AttendanceDto.builder().ano(1).date("2026-02-26").status("출석").studentName("홍길동").build();
        attendanceDtoList.add(attendanceDto);

        return attendanceDtoList;
    }
    @GetMapping("/detail")
    public AttendanceDto attendanceGET(@RequestParam int ano){
        System.out.println("AttendaceController.attendanceDtoPrint");
        AttendanceDto attendanceDto = AttendanceDto.builder().date("2026-02-27").status("결석").studentName("김길수").ano(2).build();

        return attendanceDto;
    }
    @DeleteMapping
    public boolean attendanceDELETE(@RequestParam int ano){
        System.out.println("AttendaceController.attendanceDELETE");
        return false;
    }
    @PutMapping
    public boolean attendancePUT(@RequestBody AttendanceDto attendanceDto){
        System.out.println("attendanceDto = " + attendanceDto);
        System.out.println("AttendaceController.attendancePUT");
        return true;
    }

}
