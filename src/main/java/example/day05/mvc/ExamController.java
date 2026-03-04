package example.day05.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamController {

    @Autowired
    private ExamService examService;

    // R: 조회 select
    @GetMapping("/day05/exam")
    public List< ExamDto > findAll(){
        List< ExamDto > result = examService.findAll( );
        return result;
    }

    // C : 쓰기 insert
    @PostMapping("/day05/exam")
    public boolean save(@RequestBody ExamDto examDto ){
        return examService.save( examDto );
    }

    // D : 삭제 delete
    @DeleteMapping("/day05/exam")
    public boolean delete(@RequestParam int eno){
        return examService.delete(eno);
    }

    // U : 수정 update
    @PutMapping("/day05/exam")
    public boolean update(@RequestBody ExamDto examDto){
        return examService.update(examDto);
    }
}
