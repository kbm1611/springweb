package example.day07.practice7.controller;

import example.day07.practice7.dto.CourseDto;
import example.day07.practice7.dto.EnrollDto;
import example.day07.practice7.dto.StuduentDto;
import example.day07.practice7.entity.EnrollEntity;
import example.day07.practice7.service.AcademyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/practice7")
public class AcademyController {

    @Autowired
    private AcademyService academySvc;

    @PostMapping("/course")
    public boolean courseAdd(@RequestBody CourseDto courseDto){
        return academySvc.courseAdd(courseDto);
    }

    @PostMapping("/student")
    public boolean studentAdd(@RequestBody StuduentDto studuentDto){
        return academySvc.studentAdd(studuentDto);
    }

    @PostMapping("/enroll")
    public boolean enrollAdd(@RequestBody EnrollDto enrollDto){
        return academySvc.enrollAdd(enrollDto);
    }

    @GetMapping
    public List<EnrollDto> findAll(@RequestParam Integer enrollId ){
        return academySvc.findAll(enrollId);
    }
}
