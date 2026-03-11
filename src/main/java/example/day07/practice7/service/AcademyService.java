package example.day07.practice7.service;


import example.day07.practice7.dto.CourseDto;
import example.day07.practice7.dto.EnrollDto;
import example.day07.practice7.dto.StuduentDto;
import example.day07.practice7.entity.CourseEntity;
import example.day07.practice7.entity.EnrollEntity;
import example.day07.practice7.entity.StudentEntity;
import example.day07.practice7.repository.CourseRepository;
import example.day07.practice7.repository.EnrollRepository;
import example.day07.practice7.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AcademyService {

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private EnrollRepository enrollRepo;

    // 과정 등록
    public boolean courseAdd(CourseDto courseDto){
        CourseEntity courseEntity = courseDto.toEntity();

        return courseRepo.save(courseEntity).getCourseId() > 0;
    }

    // 학생 등록
    public boolean studentAdd(StuduentDto studuentDto){
        StudentEntity studentEntity = studuentDto.toEntity();

        return studentRepo.save( studentEntity ).getStudentId() > 0;
    }

    // 수강 등록
    public boolean enrollAdd(EnrollDto enrollDto){

        Optional<CourseEntity> courseEntity = courseRepo.findById( enrollDto.getCourseId() );
        Optional<StudentEntity> studentEntity = studentRepo.findById( enrollDto.getStudentId() );

        if( courseEntity.isPresent() && studentEntity.isPresent() ){
            EnrollEntity enrollEntity = EnrollEntity.builder().status(enrollDto.getStatus()).courseEntity(courseEntity.get()).studentEntity(studentEntity.get()).build();

            return enrollRepo.save( enrollEntity ).getEnrollId() > 0;
        }else{
            return false;
        }
    }

    public List<EnrollDto> findAll(Integer enrollId ){
        List<EnrollEntity> enrollEntityList = enrollRepo.findAll();
        List<EnrollDto> enrollDtoList = new ArrayList<>();

        enrollEntityList.forEach( enrollEntity -> {
            if(enrollEntity.getEnrollId().equals(enrollId)){
                enrollDtoList.add(enrollEntity.toDto());
            }
        });

        return enrollDtoList;
    }
}
