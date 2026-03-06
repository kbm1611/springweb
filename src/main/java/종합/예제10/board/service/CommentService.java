package 종합.예제10.board.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 종합.예제10.board.dto.CommentDto;
import 종합.예제10.board.entity.BoardEntity;
import 종합.예제10.board.entity.CommentEntity;
import 종합.예제10.board.repository.BoardRepository;
import 종합.예제10.board.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommentService {

    @Autowired
    private CommentRepository commentRepo;

    @Autowired
    private BoardRepository boardRepo;

    //등록
    public boolean cmtSvc(CommentDto commentDto){
        CommentEntity commentEntity = commentDto.toEntity();

        commentEntity.setBoardByBno(commentDto.getBno());

        return commentRepo.save(commentEntity).getCno() > 0;
    }

    //해당하는 게시판에 맞춰 조회
    public List<CommentDto> cmtPrt(Integer bno){
        List<CommentEntity> commentEntityList = commentRepo.findAll();
        List<CommentDto> commentDtoList = new ArrayList<>();
        commentEntityList.forEach(entity -> {
            if(entity.getBoardEntity().getBno().equals(bno)){
                commentDtoList.add(entity.toDto());
            }
        });
        return commentDtoList;
    }

    //삭제
    public boolean cmtDel(int cno){
        boolean exists = commentRepo.existsById(cno);
        if(exists){
            commentRepo.deleteById(cno);
            return true;
        }else{
            return false;
        }
    }

    //수정
    public boolean cmtUpd(CommentDto commentDto){
        Optional<CommentEntity> optional = commentRepo.findById(commentDto.getCno());

        if(optional.isPresent()){
            CommentEntity commentEntity = optional.get();
            commentEntity.setCcontent(commentDto.getCcontent());
            commentEntity.setCwriter(commentDto.getCwriter());
            return true;
        }else{
            return false;
        }
    }
}
